package com.example.farmersinternational.DataLayer.ExternalModel

import kotlinx.coroutines.channels.ProducerScope

data class Order(
    val orderId: Long,
    val userId: Long,
    val productId: Long,
    val price: List<Product> = emptyList(),
    val date: Long
)
