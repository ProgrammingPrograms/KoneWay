package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class GetFarmerCustomerViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository):ViewModel()
{
    fun getFarmerCustomer(orderId: Long){
        viewModelScope.launch {
            try {
                offlineFirstOrderRepository.getOrderSummary(orderId)
            }
            catch (cancelexception: CancellationException){
                throw cancelexception
            }
            catch (exception: Exception){
                throw exception //everything in the viewmodel then test
            }
        }
    }
}
//another screen to have is a scrrenen that sias that screen is for peoople whomewant to see each
//farmer with product from top to bottom butthats based on them clickcing
sealed interface FarmerCustomerPageState{
    data class Success(val farmerCustomer: OrderWithUserAndProduct): FarmersCustomersState
    data class Error(val exception: Exception ): FarmersCustomersState
    data object Loading: FarmersCustomersState

}