package com.autism.health.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.autism.health.data.model.HealthData
import kotlinx.coroutines.flow.Flow

@Dao
interface HealthDataDao {
    @Insert
    suspend fun insert(healthData: HealthData): Long

    @Update
    suspend fun update(healthData: HealthData)

    @Delete
    suspend fun delete(healthData: HealthData)

    @Query("SELECT * FROM health_data ORDER BY timestamp DESC")
    fun getAllHealthData(): Flow<List<HealthData>>

    @Query("SELECT * FROM health_data WHERE timestamp >= :startDate AND timestamp <= :endDate ORDER BY timestamp DESC")
    fun getHealthDataByDate(startDate: Long, endDate: Long): Flow<List<HealthData>>

    @Query("SELECT * FROM health_data ORDER BY timestamp DESC LIMIT 1")
    fun getLatestHealthData(): Flow<HealthData?>
}
