package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.domainModel.Order

sealed interface PlaceOrderCheckoutUiState { //during
    data class Success(val order: Order ): PlaceOrderCheckoutUiState
    data class Error(val exception: Throwable):PlaceOrderCheckoutUiState
    data object Loading: PlaceOrderCheckoutUiState

}
