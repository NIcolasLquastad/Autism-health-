package com.autism.health.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_data")
data class HealthData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val steps: Int = 0,
    val heartRate: Int = 0,
    val sleepDuration: Float = 0f,
    val caloriesBurned: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
)
