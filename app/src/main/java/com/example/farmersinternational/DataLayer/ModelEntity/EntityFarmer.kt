package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.Model.Farmer

@Entity(tableName = "EntityFarmer")
data class EntityFarmer(
    @PrimaryKey(autoGenerate = true) val farmerId: Long,

    @ColumnInfo(defaultValue = "")
    val profilePhoto:String,
    val fullName:String,
    val emailAdress: String,
    val description:String,
    @ColumnInfo(defaultValue = "")
    val postPhoto:String,
    val notifications: Int
)


