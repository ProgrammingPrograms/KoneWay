package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface notificationsDao {
//should be main safe suspend
    @Query("SELECT * FROM notificationsModel")
  suspend fun fetchNotifications(): Flow<List<notificationsModel>>

    @Upsert
    suspend fun upsertNotifications(notifications: notificationsModel)

    @Delete
suspend fun deletenotification(notifications: notificationsModel)

//fix thought processes in this

}