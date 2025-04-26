package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import javax.inject.Inject

class DeleteProductViewModel@Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository,
                                                savedStateHandle: SavedStateHandle
): ViewModel()
{
    val productId: Long = savedStateHandle["productId"]?:throw IllegalArgumentException("productId is missing")

}
