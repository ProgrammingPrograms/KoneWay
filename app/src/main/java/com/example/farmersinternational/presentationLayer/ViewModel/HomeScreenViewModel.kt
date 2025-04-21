package com.example.farmersinternational.presentationLayer.ViewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.model.FarmerWithProduct
import com.example.farmersinternational.dataLayer.model.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import com.example.farmersinternational.presentationLayer.UiState.GeneralState
import com.example.farmersinternational.presentationLayer.UiState.asGeneralState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
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
            initialValue = HomeScreenUiState.Loading)
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
            farmerWithProduct =  getFarmersWithProductsStream
        )
    )

}

sealed interface HomeScreenUiState {
    data class Success(
        val products: Flow<List<Product>>,
        val farmerWithProduct: Flow<List<FarmerWithProduct>>): HomeScreenUiState
    data class  Error(val exception: Throwable): HomeScreenUiState
    data object Loading: HomeScreenUiState

}

// create a state, weatheer or not itssuccessor erroror loading and
// and create an extensionfunction  that is a generic type value that value is a wrapped around thestate
//and it outputs 1 of the states which is success with 2 of the states being static 1being on startand other being on weather
//or not theres an error
//that function wraps each value in a success statee

