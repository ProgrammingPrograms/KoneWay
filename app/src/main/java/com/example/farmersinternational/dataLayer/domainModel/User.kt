package com.example.farmersinternational.dataLayer.model

import com.example.farmersinternational.dataLayer.roomModel.EntityUser

data class User(
    val userId:Long? = null,
    val fullName: String,
    val profilePhoto: String,
    val userOnFootOnBikeOnCar: Int,
    val notifications: Int? = null
)

fun User.asEntityModel() = EntityUser(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto,
    userOnFootOnBikeOnCar =userOnFootOnBikeOnCar,
    notification = notifications
)