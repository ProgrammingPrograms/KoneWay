package com.example.farmersinternational.DataLayer.DataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class notificationsModel(
  @PrimaryKey(autoGenerate = true)
  val id: Int? = null,
    val notifications: Int? = null,

)
