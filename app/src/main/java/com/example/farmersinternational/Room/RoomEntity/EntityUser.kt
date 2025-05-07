package com.example.farmersinternational.dataLayer.RoomEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.dataLayer.domainModel.User

@Entity
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val userId: Long? = null,
    val fullName: String,
    @ColumnInfo(defaultValue = "")
    val profilePhoto: String,
    @ColumnInfo(defaultValue = "0")
    val userOnFootOnBikeOnCar: Int,
    @ColumnInfo(defaultValue = "0")
     val notification: Int
    )

fun EntityUser.asExternalModel() = User(
    userId = userId,
    fullName = fullName,
    profilePhoto = profilePhoto ,
    userOnFootOnBikeOnCar =  userOnFootOnBikeOnCar,
    notifications = notification
)