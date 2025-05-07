package com.example.farmersinternational.presentationLayer.viewmodeldelete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteUserAccountViewModel@Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository,
    private val offlineFirstOrderRepository: OfflineFirstOrderRepository, ): ViewModel()
{
    fun deleteUserAccount(userId: Long, orderId: Long){
        viewModelScope.launch {
            try {
                offlineFirstUserRepository.deleteUser(userId)
            }
            catch (exception: Exception){
                throw exception
            }
        }

    }
}