package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.ExternalModel.UserCart

@Entity(tableName = "EntityUserCart", foreignKeys = [ForeignKey(entity = EntityUser::class, parentColumns = ["userId"], childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE)])
data class EntityUserCart(
    @PrimaryKey(autoGenerate = true) val userCartId: Long,
    val userId: Long,
    val productId:Long,
    val price: List<EntityProduct> = emptyList()

)

fun EntityUserCart.asExternalModel() = UserCart(

    userCartId = userCartId,
    userId = userId,
    productId = productId,
    price = price
)

