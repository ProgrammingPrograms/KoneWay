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

class FarmerLookingAtUsersComingViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
    savedStateHandle: SavedStateHandle)
    : ViewModel(){
        private val orderIds:Set<Long> = savedStateHandle["orderIds"]?: throw IllegalArgumentException("orderIds not found")


        val usersWhoBuyUiState: StateFlow<UsersWhoBuyUiState> = usersWhoBuyUiState(
            orderIds = orderIds,
            offlineFirstOrderRepository = offlineFirstOrderRepository
        )
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5.seconds),
                initialValue = UsersWhoBuyUiState.Loading

            )
}
private fun usersWhoBuyUiState(orderIds:Set<Long>,
                               offlineFirstOrderRepository: OfflineFirstOrderRepository): Flow<UsersWhoBuyUiState> {//outstide of viewmodel
    val usersWhoBuyStream = offlineFirstOrderRepository.getOrdersSummary(orderIds)
    return flowOf(UsersWhoBuyUiState.Success(
        orderWithUserAndProduct = usersWhoBuyStream // how to implement the  Error
    )
    )

}


sealed interface UsersWhoBuyUiState{
    data class Success(val orderWithUserAndProduct: Flow<List<OrderWithUserAndProduct>>): UsersWhoBuyUiState
    data class Error(val exception:Throwable): UsersWhoBuyUiState
    data object Loading: UsersWhoBuyUiState
}