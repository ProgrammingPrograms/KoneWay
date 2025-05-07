package com.example.farmersinternational.presentationLayer.viewmodeladd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.domainlayer.CalculateOrderPriceUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject



class AddOrderViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
    private val calculateOrderPriceUseCase: CalculateOrderPriceUseCase
):ViewModel()
{
    fun getUserOrder(){
        viewModelScope.launch {
            try {
                calculateOrderPriceUseCase
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