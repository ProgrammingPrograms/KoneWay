package com.example.farmersinternational.presentationLayer.viewmodeldelete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class DeleteOrderViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
):ViewModel()
{
  fun deleteOrder(orderId: Long){
      viewModelScope.launch {
          try {
              offlineFirstOrderRepository.deleteUserOrder(orderId)
          }
          catch (e: CancellationException){
          throw e
      }
          catch (e: Exception){
              throw e
          }
      }
  }
}