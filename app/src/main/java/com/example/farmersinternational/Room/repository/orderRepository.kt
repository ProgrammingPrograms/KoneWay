package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.domainModel.Order
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun insertOrIgnoreOrder(order: Order): Long
    suspend fun createOrUpdateOrder(order: Order):Long
    fun getUserOrder(userId: Long): Flow<Order>
    fun getOrderSummary(orderId: Long): Flow<OrderWithUserAndProduct>
    fun getOrdersSummary(orderIds: Set<Long>):Flow<List<OrderWithUserAndProduct>>
    fun getOrderId(orderId: Long):Flow<Long>
    suspend fun  deleteUserOrder(orderId: Long)
}