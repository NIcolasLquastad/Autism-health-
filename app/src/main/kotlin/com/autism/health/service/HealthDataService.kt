package com.autism.health.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult
import com.samsung.android.sdk.healthdata.HealthDataStore
import com.samsung.android.sdk.healthdata.HealthPermissionManager
import timber.log.Timber

class HealthDataService : Service() {

    private var healthDataStore: HealthDataStore? = null

    override fun onCreate() {
        super.onCreate()
        Timber.d("HealthDataService created")
        initializeSamsungHealth()
    }

    private fun initializeSamsungHealth() {
        // Initialize Samsung Health SDK
        if (HealthDataStore.isAvailable(this)) {
            healthDataStore = HealthDataStore(this, object : HealthDataStore.ConnectionListener {
                override fun onConnected() {
                    Timber.d("Samsung Health connected")
                    requestHealthPermissions()
                }

                override fun onConnectionFailed(error: HealthConnectionErrorResult) {
                    Timber.e("Samsung Health connection failed: ${error.errorCode}")
                }

                override fun onDisconnected() {
                    Timber.d("Samsung Health disconnected")
                }
            })
            healthDataStore?.connect()
        } else {
            Timber.w("Samsung Health not available on this device")
        }
    }

    private fun requestHealthPermissions() {
        // Request necessary health permissions
        val permissionManager = HealthPermissionManager(healthDataStore)
        // TODO: Implement permission request
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        healthDataStore?.disconnect()
        Timber.d("HealthDataService destroyed")
    }
}
