package com.example.farmersinternational.Core.Database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.Core.model.User

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