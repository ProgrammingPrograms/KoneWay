package com.example.farmersinternational.UILayer.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farmersinternational.States.shoppingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class userCartViewModel: ViewModel(){

    private val _shoppingState = mutableStateOf(shoppingState())
    val shoppingState: State<shoppingState> = _shoppingState


    fun isItemClicked(){
        _shoppingState.value = _shoppingState.value.copy(isItemClicked = !_shoppingState.value.isItemClicked)
        }                                                           }        //whatever value is in that one
                                                                              //flip it !like a light switch
//