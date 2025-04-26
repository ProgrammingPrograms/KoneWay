package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import javax.inject.Inject

class DeleteOrderViewModel@Inject constructor(private val offlineFirstOrderRepository: OfflineFirstOrderRepository
savedStateHandle: SavedStateHandle):ViewModel()
{
    val orderId: Long = savedStateHandle["orderId"]?:throw IllegalArgumentException("orderId is missing")

}