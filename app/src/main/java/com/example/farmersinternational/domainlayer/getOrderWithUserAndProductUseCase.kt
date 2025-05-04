package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.dataLayer.domainModel.Order
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.domainModel.Product
import com.example.farmersinternational.dataLayer.domainModel.User
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

//raw data transformation logic. inputs outputs
class GetOrderWithUserAndProductUseCase@Inject constructor(
     val offlineFirstOrderRepository: OfflineFirstOrderRepository,
   private val  offlineFirstProductRepository: OfflineFirstProductRepository,
   private val  offlineFirstUserRepository: OfflineFirstUserRepository) {

    suspend operator fun invoke(orderId: Long, productId: Long, userId:Long) {
        val orderData = offlineFirstOrderRepository.getOrderId(orderId) //id
        val userData = offlineFirstUserRepository.getUserPhoto(userId)// photo
        val productData = offlineFirstProductRepository.getProductPhoto(productId)//photo
        val newFlow =  combine(orderData,userData,productData){
                orders,users,product -> Triple(orders,users,product)
        }
        newFlow.filter {(orders,users,product)->
            orders.userId == users.userId && orders.productId == product.productId
        }
            .collect{it ->
                print(it)

        }
    }
}
