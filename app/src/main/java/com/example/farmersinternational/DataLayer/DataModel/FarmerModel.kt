package com.example.farmersinternational.DataLayer.DataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class farmerModel(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,

    val farmerProfilePhoto:String? = null,
    val farmerFullName:String = "",
    val farmerDescription:String = "",
    val postPhoto:String? = null,
    val isGmo: Boolean = false,
    val isOrganic: Boolean = false,
    val isGrownIn: String = ""

   // val isNearby: Boolean =  false //not sure if this is state
    //on each persons profile page, and tells cumilitive things ie, sells halal meat, if isHalal and if is sellingmeat
    // as an extra layer of clarity for user
)
