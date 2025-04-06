package com.example.farmersinternational.States


data class shoppingState(
    val isItemClicked: Boolean = false,

)
//add photoye
enum class checkOutStepsState{
    FIRST_STEP, // whats in cart
    SECOND_STEP,// Full Name, writing name etc, writing if there on bike through state
    THIRD_STEP,//how they will be getting there Bike, Car, etc + location on the side maps api
    FOURTH_STEP,//checkout, with information of location etc

    //add this, remove all payment information, then notify farmer of amount of people

    //whom want to buy products. then and what type of product, then farmer sais which meetup/where

    //he wants to to notify where its at
}










// information you're dealing with needs to change
// dynamically, based on user interaction or other events