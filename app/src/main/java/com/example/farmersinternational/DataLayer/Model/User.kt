package com.example.farmersinternational.DataLayer.Model

data class User(
    val userId:Long,
    val fullName: String,
    val profilePhoto: String,
    val userOnfootOnBikeOnCar: Int,
    val notifications: Int
)

//want the oder to be saved on the userprofile, whenever he looks at all previous orders
//saved, persisted, orders(foodstuffs, farmer,distance,price)
//user has access. get orders from user, get from orderentity whwhere

notifications can help wotj the isercart
