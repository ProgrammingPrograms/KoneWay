package com.example.farmersinternational.Core.Database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.Core.model.Farmer

@Entity(tableName = "EntityFarmer")
data class EntityFarmer(
    @PrimaryKey(autoGenerate = true) val farmerId: Long,

    @ColumnInfo(defaultValue = "")
    val profilePhoto:String,
    val fullName:String,
    val emailAdress: String,
    val description:String,
    @ColumnInfo(defaultValue = "")
    val notifications: Int
)

fun EntityFarmer.asExternalModel() = Farmer(
farmerId = farmerId,
    profilePhoto =profilePhoto,
    fullName = fullName,
    emailAdress = emailAdress,
    description = description,
    notifications = notifications
)
