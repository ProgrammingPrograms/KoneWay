package com.example.farmersinternational.DataLayer.ExternalModel

data class User(
    val userId:Long,
    val fullName: String,
    val profilePhoto: String,
    val userOnFootOnBikeOnCar: Int,
    val notifications: Int
)

