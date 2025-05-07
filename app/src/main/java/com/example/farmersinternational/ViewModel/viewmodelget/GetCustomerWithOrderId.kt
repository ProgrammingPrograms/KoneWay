package com.example.farmersinternational.presentationLayer.viewmodelget

ackage com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.entity.OrderWithUserAndProduct
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
}//how to do states of usecases

sealed interface CustomerState{
    data class Success(private val orderWithUserAndProduct: OrderWithUserAndProduct): CustomerState
    data class Error(val e:Exception): CustomerState
    data object Loading: CustomerState
}