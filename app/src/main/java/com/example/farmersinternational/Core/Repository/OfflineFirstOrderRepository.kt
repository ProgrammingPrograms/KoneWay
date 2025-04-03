package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.OrderDao
import com.example.farmersinternational.Core.Database.model.asExternalModel
import com.example.farmersinternational.Core.domainmodel.Order
import com.example.farmersinternational.Core.domainmodel.asEntitymodel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
                                  //private val so none can access this dao apart from the repo
class OfflineFirstOrderRepository @Inject constructor(private val orderDao: OrderDao ): OrderRepository {
    override suspend fun insertOrIgnoreOrder(domainModel: Order) =
        orderDao.insertOrIgnoreOrder(domainModel.asEntitymodel())

                                      override suspend fun createOrUpdateOrder(domainModel: Order): Long =
                                          orderDao.createOrUpdateOrder(domainModel.asEntitymodel())

                                      override fun getUserOrder(userId: Long): Flow<Order> =
                                          orderDao.getUserOrder(userId).map { it.asExternalModel() }

                                      override suspend fun deleteUserOrder(orderId: Long) =
                                          orderDao.deleteUserOrder(orderId)


                                  }