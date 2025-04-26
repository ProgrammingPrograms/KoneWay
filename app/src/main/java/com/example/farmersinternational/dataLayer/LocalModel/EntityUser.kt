package com.example.farmersinternational.dataLayer.LocalModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.dataLayer.domainModel.User

@Entity
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val userId: Long? = null,
    val fullName: String,
    val profilePhoto: String,
    val userOnFootOnBikeOnCar: Int,
     val notification: Int? = null,
    )

fun EntityUser.asExternalModel() = User(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto ,
    userOnFootOnBikeOnCar =  userOnFootOnBikeOnCar,
    notifications = notification
)