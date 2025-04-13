package com.example.farmersinternational.presentationLayer.UiState

import com.example.farmersinternational.dataLayer.model.FarmerWithProduct
import com.example.farmersinternational.dataLayer.model.Product

sealed interface HomeScreenUiState {
    data object Loading: HomeScreenUiState
    data class Success(
        val products: List<Product> = emptyList(),
        val farmerWithProduct: List<FarmerWithProduct> = emptyList())
}