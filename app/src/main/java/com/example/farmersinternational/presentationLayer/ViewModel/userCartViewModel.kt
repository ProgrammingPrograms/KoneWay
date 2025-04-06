package com.example.farmersinternational.UILayer.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farmersinternational.presentationLayer.state.shoppingState

class userCartViewModel: ViewModel(){

    private val _shoppingState = mutableStateOf(shoppingState())
    val shoppingState: State<shoppingState> = _shoppingState


    fun isItemClicked(){
        _shoppingState.value = _shoppingState.value.copy(isItemClicked = !_shoppingState.value.isItemClicked)
        }                                                           }        //whatever value is in that one
                                                                              //flip it !like a light switch
//