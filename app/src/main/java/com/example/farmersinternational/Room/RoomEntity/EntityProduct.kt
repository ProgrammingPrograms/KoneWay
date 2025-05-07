package com.example.farmersinternational.dataLayer.RoomEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.dataLayer.domainModel.Product

@Entity(tableName = "EntityProduct",
    foreignKeys = [ForeignKey(entity = EntityFarmer::class,
        parentColumns = ["farmerId"],
        childColumns = ["farmerId"],
        onDelete = ForeignKey.CASCADE),
    ])
data class EntityProduct(
 @PrimaryKey(autoGenerate = true)val productId: Long?= null,
    val farmerId:Long?= null,
    val imageUrl: String,
    val name: String = "",
    val price: Int = 0,
 @ColumnInfo(defaultValue = "")
    val description: String,
     val fruitOrVegetable: Boolean? = false,
    val isGmo: Boolean = false,
    val isOrganic: Boolean = false,
 @ColumnInfo(defaultValue = "")
    val isGrownIn: String
)
fun EntityProduct.asExternalModel()= Product(
    productId =productId,
    farmerId = farmerId,
    imageUrl = imageUrl,
    name = name,
    price = price,
    description = description,
    fruitOrVegetable = fruitOrVegetable,
    isGmo = isGmo,
    isOrganic = isOrganic,
    isGrownIn = isGrownIn
)