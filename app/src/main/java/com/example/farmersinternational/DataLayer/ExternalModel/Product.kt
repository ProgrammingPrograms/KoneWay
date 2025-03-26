package com.example.farmersinternational.DataLayer.ExternalModel

data class Product(
    val productId: Long,
    val farmerId:Long,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val description: String,
    val isGmo: Boolean,
    val isOrganic: Boolean,
    val isGrownIn: String,

    )
