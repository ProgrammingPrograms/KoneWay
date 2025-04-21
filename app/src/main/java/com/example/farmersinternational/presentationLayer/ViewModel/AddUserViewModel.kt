package com.example.farmersinternational.presentationLayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.domainModel.User
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NewUserUiState(
    val userId:Long? = null,
    val fullName: String = "",
    val profilePhoto: String = "",
    val userOnFootOnBikeOnCar: Int = 0,
    val notifications: Int? = null,
    val isAddingUserComplete: Boolean = false,
)
class AddUserViewModel@Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository):ViewModel()   {

    val _userUiState = MutableStateFlow(NewUserUiState())
     val userUiState:StateFlow<NewUserUiState>  =  _userUiState.asStateFlow()

    private fun addNewUser() {
        viewModelScope.launch {
            val newUser = User(
                userUiState.value.userId,
                userUiState.value.fullName,
                userUiState.value.profilePhoto,
                userUiState.value.userOnFootOnBikeOnCar,
                userUiState.value.notifications
                )
            try {
                offlineFirstUserRepository.insertOrIgnoreUser(newUser)
                _userUiState.update { it.copy(isAddingUserComplete = true) }
            }
            catch (cancellationException: CancellationException){
                throw cancellationException
            }
            catch (exception:Exception){
                throw exception
            }
        }
        }

        }
