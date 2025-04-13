package com.example.farmersinternational.presentationLayer.state

import com.example.farmersinternational.dataLayer.model.Order

sealed interface PlaceOrderCheckoutUiState {
    data object Loading: PlaceOrderCheckoutUiState
    data class Success(val order: Order ): PlaceOrderCheckoutUiState
}
//name it the screens //
//UiStates are named the screens
// see hoow to sort the usecase of the users to be that whenever the user does xyz it tells the farmer
//how many users are coming to them
