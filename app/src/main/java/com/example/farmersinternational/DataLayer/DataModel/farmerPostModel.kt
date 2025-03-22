package com.example.farmersinternational.DataLayer.DataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class farmerPostModel(
  @PrimaryKey(autoGenerate = true) val id: Int? = null,

    val postPhoto:String? = null,
    val isGmo: Boolean = false,
    val isOrganic: Boolean = false,
    val isGrownIn: String = ""
)