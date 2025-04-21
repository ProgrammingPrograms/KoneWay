package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.model.Order

sealed interface PlaceOrderCheckoutUiState { //during
    data class Success(val order: Order ): PlaceOrderCheckoutUiState
    data class Error(val exception: Throwable):PlaceOrderCheckoutUiState
    data object Loading: PlaceOrderCheckoutUiState

}
