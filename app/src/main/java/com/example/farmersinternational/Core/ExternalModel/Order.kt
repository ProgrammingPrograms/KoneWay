package com.example.farmersinternational.DataLayer.ExternalModel

import com.example.farmersinternational.DataLayer.ModelEntity.EntityProduct

data class Order(
    val orderId: Long,
    val userId: Long,
    val productId: Long,
    val price: Double,
    val date: Long
)