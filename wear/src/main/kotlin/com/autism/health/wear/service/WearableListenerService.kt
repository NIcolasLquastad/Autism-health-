package com.autism.health.wear.service

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService
import timber.log.Timber

class WearableListenerService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        // Handle data received from companion app
        val action = intent.action
        Timber.d("Received action: $action")

        when (action) {
            "com.autism.health.SYNC_DATA" -> {
                handleDataSync(intent)
            }
            "com.autism.health.UPDATE_MOOD" -> {
                handleMoodUpdate(intent)
            }
            "com.autism.health.UPDATE_SETTINGS" -> {
                handleSettingsUpdate(intent)
            }
        }
    }

    private fun handleDataSync(intent: Intent) {
        // Process incoming data from phone app
        Timber.d("Syncing data from companion app")
        // TODO: Implement data sync logic
    }

    private fun handleMoodUpdate(intent: Intent) {
        // Update mood tracking from phone
        val mood = intent.getStringExtra("mood")
        val level = intent.getIntExtra("level", 0)
        Timber.d("Mood update received: $mood - $level")
    }

    private fun handleSettingsUpdate(intent: Intent) {
        // Update watch settings from phone
        Timber.d("Settings update received")
    }
}
