package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteUserAccountViewModel@Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository,
    private val offlineFirstOrderRepository: OfflineFirstOrderRepository,
savedStateHandle: SavedStateHandle): ViewModel()
{
    private val userId:Long = savedStateHandle["userId"]?: throw IllegalArgumentException("userId is Missing")
    private val orderId:Long  = savedStateHandle["orderId"]?: throw IllegalArgumentException("orderId is Missing")

    fun deleteUserAccount(){
        viewModelScope.launch {
            try {
                offlineFirstUserRepository.deleteUser(userId)
                offlineFirstOrderRepository.deleteUserOrder(orderId)
            }
            catch (exception: Exception){
                throw exception
            }
        }

    }
}