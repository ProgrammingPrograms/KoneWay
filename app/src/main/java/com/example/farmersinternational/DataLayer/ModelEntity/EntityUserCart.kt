package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.Model.UserCart

@Entity(tableName = "EntityUserCart", foreignKeys = [ForeignKey(entity = EntityUser::class, parentColumns = ["userId"], childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE)])
data class EntityUserCart(
    @PrimaryKey(autoGenerate = true) val userCartId: Long,
    val userId: Long,
    val productId:Long,
    val Quantity: Int,
    val price: Int

)

