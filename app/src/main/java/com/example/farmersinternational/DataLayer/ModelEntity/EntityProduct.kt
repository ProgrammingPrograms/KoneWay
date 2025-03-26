package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.ExternalModel.Product
import kotlinx.coroutines.delay

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
    val name: String,
    val price: Int,
    val description: String,
    val isGmo: Boolean,
    val isOrganic: Boolean,
    val isGrownIn: String,
)
fun EntityProduct.asExternalModel()= Product(
    productId =productId,
    farmerId = farmerId,
    imageUrl = imageUrl,
    name = name,
    price = price,
    description = description,
    isGmo = isGmo,
    isOrganic = isOrganic,
    isGrownIn = isGrownIn
)