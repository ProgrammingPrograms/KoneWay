package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.model.User

sealed interface FarmersMultipleCustomersUiState {
    data object Loading: FarmersMultipleCustomersUiState
    data class Success(val user: List<User> = emptyList()): FarmersMultipleCustomersUiState
}


sealed interface FarmerSingleCustomerUiState{
    data object loading :FarmerSingleCustomerUiState
    data class Success(val users: User):FarmerSingleCustomerUiState

//default value +no nulls predictiable:
}