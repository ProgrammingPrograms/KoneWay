package com.example.farmersinternational.dataLayer.domainModel

import com.example.farmersinternational.dataLayer.RoomEntity.EntityUser

data class User(
    val userId:Long? = null,
    val fullName: String = "",
    val profilePhoto: String = "",
    val userOnFootOnBikeOnCar: Int = 0,
    val notifications: Int
)

fun User.asEntityModel() = EntityUser(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto,
    userOnFootOnBikeOnCar =userOnFootOnBikeOnCar,
    notification = notifications
)