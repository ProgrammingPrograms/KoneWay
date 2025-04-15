package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun  homeScreenUiState(
    productIds: Set<Long>,//use case = combine and transformations
    farmerIds: Set<Long>,
    offlineFirstProductRepository: OfflineFirstProductRepository
): MutableStateFlow<HomeScreenUiState.Success> {
    val productData = offlineFirstProductRepository.getProducts(productIds)
    val farmerWithProductData = offlineFirstProductRepository.getProductsMainPage(farmerIds)

    return MutableStateFlow(HomeScreenUiState.Success(productData, farmerWithProductData))
}