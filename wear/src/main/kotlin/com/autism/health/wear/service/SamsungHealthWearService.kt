package com.autism.health.wear.service

import android.content.Context
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult
import com.samsung.android.sdk.healthdata.HealthDataStore
import com.samsung.android.sdk.healthdata.HealthPermissionManager
import com.samsung.android.sdk.healthdata.HealthResultHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class SamsungHealthWearService(private val context: Context) {

    private var healthDataStore: HealthDataStore? = null
    private val _connectionStatusFlow = MutableStateFlow(false)
    val connectionStatusFlow: Flow<Boolean> = _connectionStatusFlow.asStateFlow()

    fun connect() {
        if (HealthDataStore.isAvailable(context)) {
            healthDataStore = HealthDataStore(context, object : HealthDataStore.ConnectionListener {
                override fun onConnected() {
                    Timber.d("Samsung Health connected")
                    _connectionStatusFlow.value = true
                    requestHealthPermissions()
                }

                override fun onConnectionFailed(error: HealthConnectionErrorResult) {
                    Timber.e("Samsung Health connection failed: ${error.errorCode}")
                    _connectionStatusFlow.value = false
                }

                override fun onDisconnected() {
                    Timber.d("Samsung Health disconnected")
                    _connectionStatusFlow.value = false
                }
            })
            healthDataStore?.connect()
        } else {
            Timber.w("Samsung Health not available on this watch")
            _connectionStatusFlow.value = false
        }
    }

    private fun requestHealthPermissions() {
        val permissionManager = HealthPermissionManager(healthDataStore)
        val permissions = arrayOf(
            HealthPermissionManager.PermissionKey.HEART_RATE,
            HealthPermissionManager.PermissionKey.STEP_COUNT,
            HealthPermissionManager.PermissionKey.SLEEP,
            HealthPermissionManager.PermissionKey.OXYGEN_SATURATION
        )
        
        try {
            permissionManager.requestPermissions(permissions)
            Timber.d("Health permissions requested")
        } catch (e: Exception) {
            Timber.e(e, "Error requesting health permissions")
        }
    }

    fun writeHeartRateData(heartRate: Int, timestamp: Long) {
        // Write heart rate data to Samsung Health
        try {
            Timber.d("Writing heart rate data: $heartRate bpm")
            // Implementation pending Samsung Health SDK details
        } catch (e: Exception) {
            Timber.e(e, "Error writing heart rate data")
        }
    }

    fun writeStepData(steps: Int, timestamp: Long) {
        // Write step data to Samsung Health
        try {
            Timber.d("Writing step data: $steps steps")
            // Implementation pending Samsung Health SDK details
        } catch (e: Exception) {
            Timber.e(e, "Error writing step data")
        }
    }

    fun disconnect() {
        healthDataStore?.disconnect()
        Timber.d("Samsung Health disconnected")
    }
}
