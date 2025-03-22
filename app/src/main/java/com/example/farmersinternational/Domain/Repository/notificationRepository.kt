package com.example.farmersinternational.Domain.Repository

import android.content.Context
import com.example.farmersinternational.DataLayer.DataModel.appDatabase
import com.example.farmersinternational.DataLayer.DataModel.notificationsModel

class notificationRepository(private val AppDatabase: appDatabase, context: Context){

    val notificationInformation = appDatabase.getDatabase(context).getNotificationDataSource()

    suspend fun upsertNotificationData(NotificationModel: notificationsModel){
        notificationInformation.upsertNotifications(NotificationModel)}

       suspend fun fetchNotificationData() = notificationInformation.fetchNotifications()

      suspend fun deleteNotificationData(){
            notificationInformation.deletenotification(notificationsModel())
        }


}