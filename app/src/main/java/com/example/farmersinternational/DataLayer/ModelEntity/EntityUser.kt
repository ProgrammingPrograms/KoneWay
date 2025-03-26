package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.ExternalModel.User

data class EntityUser(
    @PrimaryKey(autoGenerate = true) val userId: Long,
    val fullName: String,
    val profilePhoto: String,
    val userOnfootOnBikeOnCar: Int,
     val notification: Int,
    )

fun EntityUser.asExternalModel() = User(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto ,
    userOnfootOnBikeOnCar =  userOnfootOnBikeOnCar,
    notifications = notification
)