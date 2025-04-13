package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import com.example.farmersinternational.dataLayer.repository.UserRepository
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class PairFarmerToUserUseCase @Inject constructor(
    private val orderRepository: OfflineFirstOrderRepository
){
    operator fun invoke(userId:Set<Long>) =
        orderRepository.getOrderSummary(userId)

    }
// pair like a video game where you have rectangle user faceon leftside(square) farmerproduct onrightside(square)
    //And above long rectangle is the OrderNumbe