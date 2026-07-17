package com.autism.health.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "mood_entries")
data class MoodEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val mood: String, // happy, calm, anxious, overwhelmed, sad
    val sensoryLevel: Int, // 1-10 scale
    val notes: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
