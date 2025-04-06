package com.example.farmersinternational.States

data class userLoginState(

    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isUserLoggedIn:Boolean = false
)