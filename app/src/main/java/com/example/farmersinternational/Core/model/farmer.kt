package com.example.farmersinternational.Core.ExternalModel



data class Farmer(
    val farmerId:Long,
val profilePhoto:String,
val fullName:String,
val emailAdress: String,
val description:String,
    val notifications: Int
)

//make all data classes uppercase
