package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.domainlayer.GetOrderWithUserAndProductUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCustomerWithOrderId@Inject constructor(private val getOrderWithUserAndProductUseCase: GetOrderWithUserAndProductUseCase):ViewModel()
{
    fun getCustomerWithProduct(orderId:Long,productId:Long,userId: Long){
        viewModelScope.launch {
          getOrderWithUserAndProductUseCase(orderId,productId,userId)
        }
   }
}

sealed interface CustomerState{
    data class Success(val orderUserProduct: OrderWithUserAndProduct): CustomerState
    data class Error(val e:Exception):CustomerState
    data object Loading:CustomerState
}