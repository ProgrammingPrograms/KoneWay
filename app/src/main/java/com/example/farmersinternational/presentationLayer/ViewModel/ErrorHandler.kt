package com.example.farmersinternational.presentationLayer.ViewModel

class HandlingErrors {
    fun getErrorMessage(exception: Exception, context: String? = null):String{
        val contextMessage = context?.let { "in $it" }?: ""
        return "Something went wrong$contextMessage. try again in a few minutes Error:" +
                "${exception.message}"
    }
}