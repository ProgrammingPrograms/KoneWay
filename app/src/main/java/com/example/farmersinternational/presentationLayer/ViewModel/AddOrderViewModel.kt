package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.Order
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import javax.inject.Inject

data class AddOrderUiState(
    val orderId: Long? = null,//null
    val userId: Long? = null,
    val productId: Long? = null,
    val price: Double = 0.0,
    val date: Instant? = null,  //business logic calculate the time
    val isOrderCreated: Boolean = false


)


class AddOrderViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository):ViewModel()
{//Code LOOSE
val _orderUiState = MutableStateFlow(AddOrderUiState())
    val orderUiState: StateFlow<AddOrderUiState> = _orderUiState.asStateFlow()
    
    private fun addOrder(){
        viewModelScope.launch {//when they order the
            val newOrder = Order(
                orderUiState.value.orderId,
                orderUiState.value.userId,
                orderUiState.value.productId,
                orderUiState.value.price,
                orderUiState.value.date,
            )
            try {
                offlineFirstOrderRepository.insertOrIgnoreOrder(newOrder)
                _orderUiState.update { it.copy(
                    isOrderCreated = true
                ) }
            }
            catch (cancellationException: CancellationException){
                throw cancellationException
            }
            catch (exception:Exception){
                throw exception
            }
        }
    }

}