package com.example.farmersinternational.presentationLayer.viewmodelget

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.entity.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class GetFarmersCustomersViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
    savedStateHandle: SavedStateHandle
): ViewModel()
{
    val orderIds: Set<Long> = savedStateHandle["orderIds"]?:throw IllegalArgumentException("orderIds is missing")

    val farmersCustomersState: Flow<FarmersCustomersState> = farmersCustomersState(
        offlineFirstOrderRepository = offlineFirstOrderRepository,
        orderIds = orderIds
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = FarmersCustomersState.Loading
        )
}

suspend fun farmersCustomersState(offlineFirstOrderRepository: OfflineFirstOrderRepository,
                          orderIds: Set<Long>): Flow<FarmersCustomersState>{
    val orderWithUserAndProduct = offlineFirstOrderRepository.getOrdersSummary(orderIds)
    return flowOf(FarmersCustomersState.Success(userWithProductWithOrder = orderWithUserAndProduct))
}
// remove all the complex joins and replace them with business logic
//call them in the viewmodel as coroutines
sealed interface FarmersCustomersState{
    data class Success(val userWithProductWithOrder: Flow<List<OrderWithUserAndProduct>>) :
        FarmersCustomersState
    data class Error(val exception: Exception ): FarmersCustomersState
    data object Loading: FarmersCustomersState
}