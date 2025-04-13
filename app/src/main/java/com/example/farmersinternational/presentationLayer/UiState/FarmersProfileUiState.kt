package com.example.farmersinternational.presentationLayer.state

import com.example.farmersinternational.dataLayer.model.FarmerWithProduct
import com.example.farmersinternational.dataLayer.model.Product

sealed  interface FarmersProfileUiState {
    data object Loading: FarmersProfileUiState
    data class Success(val farmersWithProducts: List<Product> = emptyList()):FarmersProfileUiState
}
