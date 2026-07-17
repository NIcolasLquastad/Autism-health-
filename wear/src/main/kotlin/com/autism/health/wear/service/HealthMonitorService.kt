package com.autism.health.wear.service

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class HealthMonitorService(private val context: Context) : SensorEventListener {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)
    private val stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    private val _heartRateFlow = MutableStateFlow(0)
    val heartRateFlow: Flow<Int> = _heartRateFlow.asStateFlow()

    private val _stepCountFlow = MutableStateFlow(0)
    val stepCountFlow: Flow<Int> = _stepCountFlow.asStateFlow()

    private val _caloriesFlow = MutableStateFlow(0f)
    val caloriesFlow: Flow<Float> = _caloriesFlow.asStateFlow()

    private var isMonitoring = false

    fun startMonitoring() {
        if (!isMonitoring) {
            // Register heart rate sensor
            heartRateSensor?.let {
                sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                Timber.d("Heart rate sensor registered")
            }

            // Register step counter sensor
            stepCounterSensor?.let {
                sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                Timber.d("Step counter sensor registered")
            }

            isMonitoring = true
            Timber.d("Health monitoring started")
        }
    }

    fun stopMonitoring() {
        if (isMonitoring) {
            sensorManager.unregisterListener(this)
            isMonitoring = false
            Timber.d("Health monitoring stopped")
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        when (event.sensor.type) {
            Sensor.TYPE_HEART_RATE -> {
                val heartRate = event.values[0].toInt()
                _heartRateFlow.value = heartRate
                Timber.d("Heart rate: $heartRate bpm")
            }

            Sensor.TYPE_STEP_COUNTER -> {
                val steps = event.values[0].toInt()
                _stepCountFlow.value = steps
                Timber.d("Steps: $steps")
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Timber.d("Sensor accuracy changed: ${sensor?.name} - $accuracy")
    }

    // Calculated based on heart rate and activity
    fun getCaloriesBurned(): Float {
        val heartRate = _heartRateFlow.value
        val steps = _stepCountFlow.value
        // Simple calorie estimation
        return (heartRate * 0.3f) + (steps * 0.04f)
    }

    fun getHeartRate(): Flow<Int> = heartRateFlow
    fun getStepCount(): Flow<Int> = stepCountFlow
    fun getCalories(): Flow<Float> = caloriesFlow
}
