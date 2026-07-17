package com.autism.health.wear.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.autism.health.wear.databinding.ActivityWearMainBinding
import com.autism.health.wear.service.SamsungHealthWearService
import com.autism.health.wear.service.HealthMonitorService
import kotlinx.coroutines.launch
import timber.log.Timber

class WearMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWearMainBinding
    private lateinit var healthMonitorService: HealthMonitorService
    private lateinit var samsungHealthService: SamsungHealthWearService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityWearMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Initialize services
        healthMonitorService = HealthMonitorService(this)
        samsungHealthService = SamsungHealthWearService(this)
        
        Timber.d("Wear Main Activity created")
        setupUI()
        initializeServices()
        startHealthMonitoring()
    }

    private fun setupUI() {
        // Setup button listeners for watch navigation
        binding.btnHealthMonitor.setOnClickListener {
            navigateToHealthMonitor()
        }
        
        binding.btnMoodTracking.setOnClickListener {
            navigateToMoodTracking()
        }
        
        binding.btnSettings.setOnClickListener {
            navigateToSettings()
        }
    }

    private fun initializeServices() {
        lifecycleScope.launch {
            try {
                // Initialize Samsung Health connection
                samsungHealthService.connect()
                Timber.d("Samsung Health service initialized")
                
                // Start health monitoring
                healthMonitorService.startMonitoring()
                Timber.d("Health monitoring started")
            } catch (e: Exception) {
                Timber.e(e, "Error initializing services")
            }
        }
    }

    private fun startHealthMonitoring() {
        lifecycleScope.launch {
            healthMonitorService.getHeartRate().collect { heartRate ->
                updateHeartRateDisplay(heartRate)
            }
        }
        
        lifecycleScope.launch {
            healthMonitorService.getStepCount().collect { steps ->
                updateStepsDisplay(steps)
            }
        }
    }

    private fun updateHeartRateDisplay(heartRate: Int) {
        binding.tvHeartRate.text = "❤️ $heartRate bpm"
        Timber.d("Heart rate updated: $heartRate")
    }

    private fun updateStepsDisplay(steps: Int) {
        binding.tvSteps.text = "👟 $steps steps"
        Timber.d("Steps updated: $steps")
    }

    private fun navigateToHealthMonitor() {
        startActivity(
            android.content.Intent(this, WearHealthMonitorActivity::class.java)
        )
    }

    private fun navigateToMoodTracking() {
        startActivity(
            android.content.Intent(this, WearMoodTrackingActivity::class.java)
        )
    }

    private fun navigateToSettings() {
        startActivity(
            android.content.Intent(this, WearSettingsActivity::class.java)
        )
    }

    override fun onStart() {
        super.onStart()
        Timber.d("Wear activity started")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("Wear activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        healthMonitorService.stopMonitoring()
        samsungHealthService.disconnect()
    }
}
