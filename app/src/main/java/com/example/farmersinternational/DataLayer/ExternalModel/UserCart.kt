package com.example.farmersinternational.DataLayer.ExternalModel

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.farmersinternational.DataLayer.ModelEntity.EntityUser
data class UserCart(
val userCartId: Long,
val userId: Long,
val productId:Long,
val price: List<Product> = emptyList()
)
//look at it in a sql way