package com.example.farmersinternational.presentationLayer.state

import com.example.farmersinternational.dataLayer.model.User

sealed interface UserWhoBuyFromFarmersUiState {
    data object Loading: UserWhoBuyFromFarmersUiState
    data class Success(val user: User): UserWhoBuyFromFarmersUiState
}
sealed interface SingleUserWhoBuyFromFarmerUiState{
    data object loading :SingleUserWhoBuyFromFarmerUiState
    data class Success(val users: List<User> = emptyList()):SingleUserWhoBuyFromFarmerUiState

//default value +no nulls predictiable:
}