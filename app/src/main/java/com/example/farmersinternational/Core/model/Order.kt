package com.example.farmersinternational.Core.ExternalModel

data class Order(
    val orderId: Long,
    val userId: Long,
    val productId: Long,
    val price: Double,
    val date: Long
)