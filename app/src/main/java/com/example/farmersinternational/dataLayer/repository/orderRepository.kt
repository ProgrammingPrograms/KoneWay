package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.OrderDao
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityOrder
import com.example.farmersinternational.Core.domainmodel.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun insertOrIgnoreOrder(domainModel: Order): Long
    suspend fun createOrUpdateOrder(domainModel: Order):Long
    fun getUserOrder(userId: Long): Flow<Order>
    suspend fun  deleteUserOrder(orderId: Long)

// this is the direct translation to the ui
    //and because of that this only takes domeains that why
}