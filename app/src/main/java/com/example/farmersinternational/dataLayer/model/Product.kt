package com.example.farmersinternational.dataLayer.domainmodel

import com.example.farmersinternational.dataLayer.EntityModel.EntityProduct

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

fun Product.asEntityModel() = EntityProduct(
    productId = productId,
    farmerId = farmerId,
    imageUrl = imageUrl,
    name = name,
    price = price,
    description = description,
    fruitOrVegetable = fruitOrVegetable,
    isGmo = isGmo,
    isOrganic = isOrganic,
    isGrownIn = isGrownIn
)
