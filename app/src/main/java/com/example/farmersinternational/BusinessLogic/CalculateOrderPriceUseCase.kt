package com.example.farmersinternational.domainlayer

import com.example.farmersinternational.Extras.generateOrderId
import com.example.farmersinternational.dataLayer.entity.Order
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.first
import kotlinx.datetime.Clock
import javax.inject.Inject

class CalculateOrderPriceUseCase@Inject constructor(
    private val offlineFirstProductRepository: OfflineFirstProductRepository,
    private val offlineFirstOrderRepository: OfflineFirstOrderRepository) {

    suspend operator fun invoke(productIds: Set<Long>, userId: Long, orderId: Long):Order{
        val specificProducts = offlineFirstProductRepository.getProducts(productIds).first()
    val priceOfProducts = specificProducts.sumOf {it.price}
    val productsIds = specificProducts.map { it.productId }
    val now = Clock.System.now()//do it.map//watch video on collections-spec map
    val userOrder = Order(
        orderId = generateOrderId(),
        userId = userId,
        productId = productsIds,
        price = priceOfProducts,
        date = now
    )
        offlineFirstOrderRepository.insertOrIgnoreOrder(userOrder)
    return userOrder
    }


}
