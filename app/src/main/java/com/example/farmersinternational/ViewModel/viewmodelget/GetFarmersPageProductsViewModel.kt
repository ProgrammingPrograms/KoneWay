package com.example.farmersinternational.presentationLayer.viewmodelget

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.entity.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class GetFarmersPageProductsViewModel@Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository,
                                                         savedStateHandle: SavedStateHandle
): ViewModel() {
    val farmerId: Long = savedStateHandle["farmerId"] ?: throw IllegalArgumentException("Farmer Id is missing")


        val farmerState: StateFlow<FarmersPageState> = farmerStateFunction(
            offlineFirstFarmersRepository = offlineFirstFarmersRepository,
            farmerId = farmerId
        ).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = FarmersPageState.Loading
            )





}
sealed interface FarmersPageState {
    data class Success(val farmerWithProduct: Flow<List<Product>>) : FarmersPageState
    data class Error(val exception: Throwable) : FarmersPageState
    data object Loading : FarmersPageState
}

 fun farmerStateFunction(offlineFirstFarmersRepository: OfflineFirstFarmersRepository,
farmerId: Long):Flow<FarmersPageState> {
    val farmersProducts = offlineFirstFarmersRepository.getFarmersProducts(farmerId)
return flowOf(FarmersPageState.Success(farmerWithProduct = farmersProducts))

}

