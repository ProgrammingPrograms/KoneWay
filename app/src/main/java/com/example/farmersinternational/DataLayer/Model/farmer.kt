package com.example.farmersinternational.DataLayer.Model



data class Farmer(
    val farmerId:Long,
val profilePhoto:String,
val fullName:String,
val emailAdress: String,
val description:String,
val postPhoto:String,
val isGmo: Boolean,
val isOrganic: Boolean,
val isGrownIn: String,
    val notifications: Int
)

//make all data classes uppercase
