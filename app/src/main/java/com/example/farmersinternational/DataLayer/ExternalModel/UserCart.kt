package com.example.farmersinternational.DataLayer.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.farmersinternational.DataLayer.ModelEntity.EntityUser

@Entity(tableName = "UserCart",
    foreignKeys = [ForeignKey(entity = EntityUser::class,
        parentColumns = ["userId"], childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE)])
data class UserCart(
val id: Long,
val userId: Long,
val productId:Long,
val Quantity: Int,
val price: Int
)
//look at it in a sql way