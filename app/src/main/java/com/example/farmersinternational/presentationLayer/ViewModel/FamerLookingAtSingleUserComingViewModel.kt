package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class FarmerLookingAtSingleUserComingViewModel@Inject constructor(
    private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
    savedStateHandle: SavedStateHandle) :ViewModel()
{
    private val orderId:Long = savedStateHandle["orderIds"]?: throw IllegalArgumentException("orderId is missing")

    val userWhoBuyUiState: StateFlow<UserWhoBuyUiState> = userWhoBuyUiState(
        orderId = orderId,
        offlineFirstOrderRepository = offlineFirstOrderRepository
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = UserWhoBuyUiState.Loading

        )
}
private fun userWhoBuyUiState(orderId:Long,
                               offlineFirstOrderRepository: OfflineFirstOrderRepository): Flow<UserWhoBuyUiState> {
    val userWhoBuyStream = offlineFirstOrderRepository.getOrderSummary(orderId)
    return flowOf(UserWhoBuyUiState.Success(
        orderWithUserAndProduct = userWhoBuyStream
    ))

}

//deletes
sealed interface UserWhoBuyUiState{
    data class Success(val orderWithUserAndProduct: Flow<OrderWithUserAndProduct>): UserWhoBuyUiState
    data class Error(val exception:Throwable): UserWhoBuyUiState
    data object Loading: UserWhoBuyUiState
}