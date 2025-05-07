package com.example.farmersinternational.presentationLayer.viewmodeldelete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class DeleteProductViewModel@Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository,
): ViewModel()
{
    fun deleteProduct(productId: Long) {
        viewModelScope.launch {
            try {

                offlineFirstProductRepository.deleteProduct(productId)
            }
            catch (ce: CancellationException){
                throw ce
            }
            catch (exception: Exception){
                throw exception
            }
        }
    }


}
