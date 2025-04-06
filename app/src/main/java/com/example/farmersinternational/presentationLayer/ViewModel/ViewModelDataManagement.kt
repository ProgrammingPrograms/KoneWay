package com.example.farmersinternational.UILayer.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmersinternational.dataLayer.buildDatabase.farmerModel
import com.example.farmersinternational.presentationLayer.state.deleteAllState
import com.example.farmersinternational.presentationLayer.state.notificationDataState
import com.example.farmersinternational.presentationLayer.state.userCartDataState
import com.example.farmersinternational.presentationLayer.state.FarmerInfoAndPostUiState
import com.example.farmersinternational.presentationLayer.state.FarmerInfoUiState
import com.example.farmersinternational.presentationLayer.state.FarmerPostUiState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.merge
import kotlin.time.Duration.Companion.seconds

class farmersInformationManagementCRUD(FarmerRepository: farmerRepository,
                                       NotifcationRepository: notificationRepository, UserCartRepository: userCartRepository): ViewModel() {

    private val _uiStateFarmerInfo = MutableStateFlow(FarmerInfoUiState())
    val uiStateFarmerInfo: StateFlow<FarmerInfoUiState> =
        _uiStateFarmerInfo.asStateFlow()


    private val _uiStateFarmerPost = MutableStateFlow(FarmerPostUiState())
    val uiStateFarmerPost: StateFlow<FarmerPostUiState> =
        _uiStateFarmerPost.asStateFlow()

    private val _uiStateFarmerPostandInfo =
        MutableStateFlow(FarmerInfoAndPostUiState())
    val uiStateFarmerPostandInfo: StateFlow<FarmerInfoAndPostUiState> =
        _uiStateFarmerPostandInfo.asStateFlow()

    private val _uiStateNotification = MutableStateFlow(notificationDataState())
    val uiStateNotification: StateFlow<notificationDataState> =
        _uiStateNotification.asStateFlow()

    private val _uiStateUserCart = MutableStateFlow(userCartDataState())
    val uiStateUserCart: StateFlow<userCartDataState> =
        _uiStateUserCart.asStateFlow()

    private val _deletedAccountState = MutableStateFlow(deleteAllState())
    val deletedAccountState: StateFlow<deleteAllState> = _deletedAccountState.asStateFlow()


    fun getErrorMessage(exception: Exception): String {
        return "Hey try again in a few Minutes ${exception.message}"
    }

    val farmerData = FarmerRepository
    val notificationDataRepo = NotifcationRepository
    val userCartData = UserCartRepository

    val FarmerInfoToBeDeleted = flow<Unit> {
        farmerData.farmerInfoData.deleteFarmerInformation(
            farmerModel()
        )
    }


    val FarmerPostToBeDeleted =
        flow<Unit> { farmerData.farmerPostData.deleteFarmerPostData(farmerPostModel()) }
    val FarmerNotificationToBeDeleted = flow<Unit> {
        notificationDataRepo.notificationInformation.deletenotification(notificationsModel())
    }
    val FarmerCartToBeDeleted = flow<Unit> {
        userCartData.cartDataSource.deleteUserCartData(
            userCartModel()
        )
    }

    fun FarmerInfoUiState.toFarmerModel() = farmerModel(

    )
    fun fetchFarmerInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                farmerData.fetchFarmerInformation()

            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {
                HandlingErrors().getErrorMessage(exception, "Loading the page")
            }
        }
    }

    fun fetchFarmerPost() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                farmerData.fetchFarmerPostInformation()
                //can add a var to check for debugging

            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {                //loading all the good foood
                HandlingErrors().getErrorMessage(exception, "Loading the page")
                //
            }
        }
    }

    fun fetchBothPostAndInfoData() {
        // maybe add a uistate bottom right check upon the user saving their information
        viewModelScope.launch(Dispatchers.IO) {//youtube channel going to all the masjids
            try {
                val farmerPostDataToBeMerged = farmerData.fetchFarmerPostSpecific()
                val farmerInfoDataToBeMerged = farmerData.fetchFarmerInfoSpecific()

                merge(farmerInfoDataToBeMerged, farmerPostDataToBeMerged).collect { value ->
                    println(value)
                }
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {                     //loading all the good foood
                HandlingErrors().getErrorMessage(exception, "Loading the page")

            }

        }
    }

    fun fetchNotificationData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notificationDataRepo.fetchNotificationData()
                delay(1.5.seconds)
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {              //loading all the good foood
                HandlingErrors().getErrorMessage(exception, "getting Notifications")
            }
        }
    }

    fun fetchUserCartData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                userCartData.fetchUserCartInformation()

            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exception: Exception) {              //loading all the good foood
                HandlingErrors().getErrorMessage(exception, "Loading the page")
            }
        }
    }

    //SAVING INFORMATION AND NOTIFICATION AND CART DATA
    fun saveFarmerPostData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                farmerData.upsertFarmerPostInformation(farmerPostModel())

            } catch (cancellationexeption: CancellationException) {
                throw cancellationexeption
            } catch (exception: Exception) {
                HandlingErrors().getErrorMessage(
                    exception, "loading Page"
                )

            }
        }
    }

    fun saveFarmerInfoData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                farmerData.upsertFarmerInformation(farmerModel())

            } catch (cancellationException: CancellationException) {
                throw cancellationException
            } catch (exeption: Exception) {
                HandlingErrors().getErrorMessage(
                    exeption,
                    "uploading your data"
                )
            }
        }
    }

    fun saveNotificationData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notificationDataRepo.upsertNotificationData(notificationsModel())

            } catch (cancellationException: CancellationException) {
                throw cancellationException

            } catch (exception: Exception) {
                HandlingErrors().getErrorMessage(exception)
            }
        }
    }

    fun saveUserCart() {
        viewModelScope.launch {
            try {
                userCartData.upsertUserCartData(userCartModel())

            } catch (cancellationException: CancellationException) {
                throw cancellationException

            } catch (exception: Exception) {
                HandlingErrors().getErrorMessage(exception)
            }
        }
    }
}
  /*  fun deleteUserAccount() = runBlocking {
            try { merge(FarmerInfoToBeDeleted,FarmerPostToBeDeleted, FarmerNotificationToBeDeleted,FarmerCartToBeDeleted)
                .onEach {  }.launchIn(this)
                _deletedAccountState.update {
                    it.copy(isLoading = true)
                }
                delay(2.seconds)
                _deletedAccountState.update {
                    it.copy(isTaskCompleted = true)
                }

            }
            catch (cancellationException: CancellationException){
                throw cancellationException
        }
        catch (exception: Exception){
            HandlingErrors().getErrorMessage(exception, "Deleting Account")
        }
    }
}

   */