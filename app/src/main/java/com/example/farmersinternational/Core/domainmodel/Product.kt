package com.example.farmersinternational.Core.model

data class Product(
    val productId: Long,
    val farmerId:Long,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val description: String,
    val fruitOrVegetable: Boolean,
    val isGmo: Boolean,
    val isOrganic: Boolean,
    val isGrownIn: String,

    )
