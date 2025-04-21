package com.example.farmersinternational.dataLayer.model

data class OrderWithUserAndProduct(
    val order: Order,
    val user: User,
    val product: Product
)
