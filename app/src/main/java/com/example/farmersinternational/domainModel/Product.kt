package com.example.farmersinternational.dataLayer.domainModel

import com.example.farmersinternational.dataLayer.RoomEntity.EntityProduct

data class Product(
    val productId: Long?= null,
    val farmerId:Long?= null,
    val imageUrl: String,
    val name: String = "",
    val price: Int = 0,
    val description: String,
    val fruitOrVegetable: Boolean?= false,
    val isGmo: Boolean = false,
    val isOrganic: Boolean = false,
    val isGrownIn: String = "",

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
