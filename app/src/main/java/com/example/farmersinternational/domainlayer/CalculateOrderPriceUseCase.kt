package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.Extras.generateOrderId
import com.example.farmersinternational.dataLayer.domainModel.Order
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.first
import kotlinx.datetime.Clock
import javax.inject.Inject

class CalculateOrderPriceUseCase@Inject constructor(
    private val offlineFirstProductRepository: OfflineFirstProductRepository,
    private val offlineFirstOrderRepository: OfflineFirstOrderRepository) {
//get specific products(basedonIds)
    //make sum of those products
    //make sum of those products = price of order.price
    //
    suspend operator fun invoke(productIds: Set<Long>, userId: Long, orderId: Long):Order{
        val specificProducts = offlineFirstProductRepository.getProducts(productIds).first()
    val priceOfProducts = specificProducts.sumOf {it.price}
    val productsIds = specificProducts.map { it.productId }
    val now = Clock.System.now()
    val userOrder = Order(
        orderId = generateOrderId(),
        userId = userId,
        productId = productsIds,
        price = priceOfProducts,
        date = now
    )
    }


}
//business logic output and input
//think simple Crud/ what i need to get then do what