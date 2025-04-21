package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.model.Product

sealed  interface FarmersProfileUiState {
    data class Success(val farmersWithProducts: List<Product> = emptyList()):FarmersProfileUiState
    data class Error(val exception: Throwable): FarmersProfileUiState
    data object Loading: FarmersProfileUiState


}
