package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteFarmerAccountViewModel@Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository,
    savedStateHandle: SavedStateHandle
):ViewModel()  {val farmerId: Long = savedStateHandle["farmerId"]?:throw IllegalArgumentException("farmerId is Missing")

    fun deleteFarmerAccount(){
        viewModelScope.launch {
            try {
                offlineFirstFarmersRepository.deleteFarmerAccount(farmerId)
                //can add the product delete
            }
           catch (exceptionCanceled:CancellationException){//by coroutines when ttheir canceleld themselves
               throw exceptionCanceled
           }
            catch (exception: Exception){
                throw exception
            }
        }
    }
}