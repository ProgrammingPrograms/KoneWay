package com.example.farmersinternational.dataLayer.model

import com.example.farmersinternational.dataLayer.roomModel.EntityOrder

data class Order(
    val orderId: Long? = null,
    val userId: Long?= null,
    val productId: Long?= null,
    val price: Double,
    val date: Long?= null
)

fun Order.asEntityModel() = EntityOrder(
    orderId = orderId,
    userId = userId,
    productId = productId,
    price = price,
    date = date
)

//add order based on the user themselves having an order//
//