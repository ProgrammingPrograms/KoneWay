package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "EntityProduct",
    foreignKeys = [ForeignKey(entity = EntityFarmer::class,
        parentColumns = ["farmerId"],
        childColumns = ["farmerId"],
        onDelete = ForeignKey.CASCADE),
    ])
data class EntityProduct(
 @PrimaryKey(autoGenerate = true)val productId: Long,
    val farmerId:Long,
    val imageUrl: String,
    val price: Int,
    val name: String,
    val Description: String,
    val isGmo: Boolean,
    val isOrganic: Boolean,
    val isGrownIn: String,

)
