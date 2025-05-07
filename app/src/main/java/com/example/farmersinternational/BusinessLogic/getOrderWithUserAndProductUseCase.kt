package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.dataLayer.entity.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import javax.inject.Inject


class GetOrderWithUserAndProductUseCase@Inject constructor(
     val offlineFirstOrderRepository: OfflineFirstOrderRepository,
   private val  offlineFirstProductRepository: OfflineFirstProductRepository,
   private val  offlineFirstUserRepository: OfflineFirstUserRepository) {

    suspend operator fun invoke(orderId: Long, productId: Long, userId:Long) {
        val orderData = offlineFirstOrderRepository.getOrderId(orderId)
        val userData = offlineFirstUserRepository.getUserPhoto(userId)
        val productData = offlineFirstProductRepository.getProductPhoto(productId)
        val newFlow =  combine(orderData,userData,productData){
                orders,users,product -> OrderWithUserAndProduct(orders, users, product)
        }
        newFlow.filter {it ->
            it.orderId == it.user.userId && it.orderId == it.product.productId
        }
            .collect{whoTheCustomer->
                print(whoTheCustomer)

        }
    }
}
