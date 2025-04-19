package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import com.example.farmersinternational.presentationLayer.UiState.HomeScreenUiState
import com.example.farmersinternational.presentationLayer.UiState.homeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val offlineFirstProductRepository: OfflineFirstProductRepository,
private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository,
savedStateHandle: SavedStateHandle ): ViewModel() {
    //for app to get save data and retrieve data when app process is killed and for configuration changes

    val homeScreenUiState: StateFlow<HomeScreenUiState> = homeScreenUiState(

    )


}