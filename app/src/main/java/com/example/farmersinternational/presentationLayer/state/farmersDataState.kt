package com.example.farmersinternational.States

data class FarmerPostUiState(
    val message: String? = null,
    val isLoading: Boolean = false,
    val isTaskCompleted: Boolean = false,
    val postPhoto: String? = null,
    val isGmo: Boolean = false,
    val isOrganic: Boolean = false,
    val isGrownIn: String = "",
    val id: Int? = null

    )
data class FarmerInfoUiState(
    val message: String? = null,
    val loading: Boolean = false,
    val isTaskCompleted: Boolean = false,
    val id: Int? = null,
    val farmerProfilePhoto:String? = null,
    val farmerFullName:String = "",
    val farmerDescription:String = "",

)
data class FarmerInfoAndPostUiState(
    val message: String? = null,
    val isLoading: Boolean = false,
    val isTaskCompleted: Boolean = false,
   val  postPhoto: String? = null,
   val  isGmo: Boolean = false,
    val isOrganic: Boolean = false,
    val farmerProfilePhoto:String? = null,
    val farmerFullName:String = "",
)
data class notificationDataState(
    val isLoading: Boolean = false,
    val  isTaskCompleted: Boolean = false,
    val id:  Int? = null,
    val notifications: Int? = null,
)
data class userCartDataState(
    val isLoading: Boolean = false,
    val  isTaskCompleted: Boolean = false,
    val id: Int? = null,
    val numberOfItemsInCart: Int? = null,
    val price: Int? = null,
)

data class deleteAllState(
    val  isTaskCompleted: Boolean = false,
    val isLoading: Boolean = false)
