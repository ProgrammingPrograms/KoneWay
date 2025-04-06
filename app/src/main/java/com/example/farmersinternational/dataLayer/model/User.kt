package com.example.farmersinternational.dataLayer.domainmodel

import com.example.farmersinternational.dataLayer.EntityModel.EntityUser

data class User(
    val userId:Long,
    val fullName: String,
    val profilePhoto: String,
    val userOnFootOnBikeOnCar: Int,
    val notifications: Int
)

fun User.asEntityModel() = EntityUser(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto,
    userOnFootOnBikeOnCar =userOnFootOnBikeOnCar,
    notification = notifications
)