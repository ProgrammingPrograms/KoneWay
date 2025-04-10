package com.example.farmersinternational.presentationLayer.state

import com.example.farmersinternational.dataLayer.model.Order

sealed interface CheckoutPlaceOrderUiState {
    data object Loading: CheckoutPlaceOrderUiState
    data class Success(val order: Order ): CheckoutPlaceOrderUiState
}

//depening on how many data you fetch for each screen