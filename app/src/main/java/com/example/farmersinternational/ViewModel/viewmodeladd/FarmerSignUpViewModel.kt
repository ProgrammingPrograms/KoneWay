package com.example.farmersinternational.presentationLayer.viewmodeladd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.entity.Farmer
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

data class FarmerUiState(
    val farmerId:Long?=null,
    val profilePhoto:String = "",
    val fullName:String= "",
    val emailAdress: String= "",
    val description:String= "",
    val notifications: Int?= null,
    val isFarmerAdded:Boolean = false
)
class AddFarmerViewModel@Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository):ViewModel() {

    val _farmerUiState = MutableStateFlow(FarmerUiState())
    val farmerUiState: StateFlow<FarmerUiState> = _farmerUiState.asStateFlow()

    private fun addNewFarmer() {
        viewModelScope.launch {
            val newFarmer = Farmer(
                farmerUiState.value.farmerId,
                farmerUiState.value.profilePhoto,
                farmerUiState.value.fullName,
                farmerUiState.value.emailAdress,
                farmerUiState.value.description,
                farmerUiState.value.notifications,
            )
            try {
                offlineFirstFarmersRepository.insertOrIgnore(newFarmer)
                _farmerUiState.update { it.copy(isFarmerAdded = true) }
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {
                throw exception
            }
        }
    }

}
