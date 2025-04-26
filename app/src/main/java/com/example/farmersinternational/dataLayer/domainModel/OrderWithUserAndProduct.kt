package com.example.farmersinternational.dataLayer.domainModel

data class OrderWithUserAndProduct(
    val order: Order,
    val user: User,
    val product: Product
)
