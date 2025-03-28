package com.example.farmersinternational.Core.ModelEntity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.Core.ExternalModel.User

@Entity
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val userId: Long,
    val fullName: String,
    val profilePhoto: String,
    val userOnFootOnBikeOnCar: Int,
     val notification: Int,
    )

fun EntityUser.asExternalModel() = User(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto ,
    userOnFootOnBikeOnCar =  userOnFootOnBikeOnCar,
    notifications = notification
)