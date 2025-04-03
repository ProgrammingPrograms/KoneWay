package com.example.farmersinternational.Core.model

import com.example.farmersinternational.Core.Database.model.EntityFarmer


data class Farmer(

    val farmerId:Long,
val profilePhoto:String,
val fullName:String,
val emailAdress: String,
val description:String,
    val notifications: Int
)

fun Farmer.asEntityModel() = EntityFarmer(
    farmerId = farmerId,
    profilePhoto = profilePhoto,
    fullName = fullName,
    emailAdress = emailAdress,
    description = description,
    notifications = notifications
)
/*
the repo is communicating directly to the ui as the domain models
so for it to do so the inserts have to be of type entities for
that extra abstraction in only showing the domain to the ui
because of some extra seperation of concerns
 */
