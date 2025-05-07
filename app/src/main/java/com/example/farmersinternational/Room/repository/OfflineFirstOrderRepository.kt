package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.dao.OrderDao
import com.example.farmersinternational.dataLayer.RoomEntity.asExternalModel
import com.example.farmersinternational.dataLayer.domainModel.Order
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.domainModel.asEntityModel
import com.example.farmersinternational.dataLayer.RoomEntity.modelJoins.OrderWithUserAndProductJoin
import com.example.farmersinternational.dataLayer.RoomEntity.modelJoins.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
                                  //private val so none can access this dao apart from the repo
class OfflineFirstOrderRepository @Inject constructor(private val orderDao: OrderDao): OrderRepository {
    override suspend fun insertOrIgnoreOrder(order: Order) =
        orderDao.insertOrIgnoreOrder(order.asEntityModel())

                                      override suspend fun createOrUpdateOrder(order: Order): Long =
                                          orderDao.createOrUpdateOrder(order.asEntityModel())

                                      override fun getUserOrder(userId: Long): Flow<Order> =
                                          orderDao.getUserOrder(userId).map { it.asExternalModel() }

                                      override fun getOrderSummary(orderId: Long):Flow<OrderWithUserAndProduct> =
                                          orderDao.getOrderSummary(orderId).map {it.asExternalModel()}

                                      override fun getOrdersSummary(orderIds: Set<Long>): Flow<List<OrderWithUserAndProduct>> =
                                          orderDao.getOrdersSummary(orderIds).map { it.map(OrderWithUserAndProductJoin::asExternalModel) }

                                      override fun getOrderId(orderId: Long): Flow<Long> =
                                          orderDao.getOrderId(orderId)


                                      override suspend fun deleteUserOrder(orderId: Long) =
                                          orderDao.deleteUserOrder(orderId)


                                  }