package com.example.farmersinternational.presentationLayer.viewmodeldelete

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteFarmerAccountViewModel@Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository,
    savedStateHandle: SavedStateHandle
):ViewModel()  {

    fun deleteFarmerAccount(farmerId: Long){
        viewModelScope.launch {
            try {
                offlineFirstFarmersRepository.deleteFarmerAccount(farmerId)
                //can add the product delete
            }
           catch (exceptionCanceled:CancellationException){
               throw exceptionCanceled
           }
            catch (exception: Exception){
                throw exception
            }
        }
    }
}