package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.PrimaryKey

data class EntityUser(
    @PrimaryKey(autoGenerate = true) val userId: Long,
    val fullName: String,
    val ProfilePhoto: String)