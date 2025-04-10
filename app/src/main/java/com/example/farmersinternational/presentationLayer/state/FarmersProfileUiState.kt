package com.example.farmersinternational.presentationLayer.state

import com.example.farmersinternational.dataLayer.model.FarmerWithProduct

sealed  interface FarmersProfileUiState {
    data object Laoding: FarmersProfileUiState
    data class Success(val farmersWithProducts: List<FarmerWithProduct> = emptyList()):FarmersProfileUiState
}//depening on how many data you fetch for each screen
sealed interface FarmersUiState {
    data object Loading : FarmersUiState
    data class Success(val )
}