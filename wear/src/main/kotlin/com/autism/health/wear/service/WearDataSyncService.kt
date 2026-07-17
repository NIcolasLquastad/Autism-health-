package com.autism.health.wear.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class WearDataSyncService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        Timber.d("WearDataSyncService created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.d("WearDataSyncService started")

        serviceScope.launch {
            try {
                // Sync data with companion phone app
                syncHealthData()
                syncMoodData()
                syncSettings()
            } catch (e: Exception) {
                Timber.e(e, "Error during data sync")
            }
        }

        return START_STICKY
    }

    private suspend fun syncHealthData() {
        Timber.d("Syncing health data with phone app")
        // TODO: Implement sync logic
    }

    private suspend fun syncMoodData() {
        Timber.d("Syncing mood data with phone app")
        // TODO: Implement sync logic
    }

    private suspend fun syncSettings() {
        Timber.d("Syncing settings with phone app")
        // TODO: Implement sync logic
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("WearDataSyncService destroyed")
    }
}
