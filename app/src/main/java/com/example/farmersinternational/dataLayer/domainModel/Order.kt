package com.example.farmersinternational.dataLayer.domainModel

import com.example.farmersinternational.dataLayer.LocalModel.EntityOrder
import kotlinx.datetime.Instant

data class Order(
    val orderId: Long? = null,
    val userId: Long?= null,
    val productId: List<Long?>? = null,
    val price: Double,
    val date: Instant?= null
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