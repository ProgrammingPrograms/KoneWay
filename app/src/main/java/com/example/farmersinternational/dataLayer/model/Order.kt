package com.example.farmersinternational.dataLayer.domainmodel

import com.example.farmersinternational.dataLayer.EntityModel.EntityOrder

data class Order(
    val orderId: Long,
    val userId: Long,
    val productId: Long,
    val price: Double,
    val date: Long
)

fun Order.asEntitymodel() = EntityOrder(
    orderId = orderId,
    userId = userId,
    productId = productId,
    price = price,
    date = date
)