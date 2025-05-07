package com.example.farmersinternational.presentationLayer.viewmodelget

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.entity.FarmerWithProduct
import com.example.farmersinternational.dataLayer.entity.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class HomeScreenViewModel @Inject constructor(
    private val offlineFirstProductRepository: OfflineFirstProductRepository,
savedStateHandle: SavedStateHandle ): ViewModel() {

private val productIds: Set<Long> = savedStateHandle["productIds"]?:throw  IllegalArgumentException("productIds is missing")
val farmerIds: Set<Long> = savedStateHandle["farmerIds"]?:throw  IllegalArgumentException("farmerIds is missing")

    val homeScreenUiState: StateFlow<HomeScreenUiState> = homeScreenUiState(
        productIds =productIds,
        farmerIds = farmerIds,
        offlineFirstProductRepository = offlineFirstProductRepository)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = HomeScreenUiState.Loading
        )
}

fun  homeScreenUiState(
    productIds: Set<Long>,//replace repos with UseCase
    farmerIds:Set<Long>,
    offlineFirstProductRepository: OfflineFirstProductRepository)
:Flow<HomeScreenUiState>{
    val getProductsStream =
        offlineFirstProductRepository.getProducts(productIds)
    val getFarmersWithProductsStream =
        offlineFirstProductRepository.getProductsMainPage(farmerIds)
    return flowOf(
        HomeScreenUiState.Success(
            products = getProductsStream,
            farmerWithProduct = getFarmersWithProductsStream
        )
    )
//20 minutes
}

sealed interface HomeScreenUiState {
    data class Success(
        val products: Flow<List<Product>>,
        val farmerWithProduct: Flow<List<FarmerWithProduct>>): HomeScreenUiState
    data class  Error(val exception: Throwable): HomeScreenUiState
    data object Loading: HomeScreenUiState

}


