package com.example.farmersinternational.dataLayer.DomainLayer

import com.example.farmersinternational.dataLayer.model.Order
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOrderUseCas @Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository) {

    operator fun invoke(userId: Long): Flow<Order> =
        offlineFirstOrderRepository.getUserOrder(userId)
}