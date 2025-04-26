package com.example.farmersinternational.Extras

fun generateOrderId():Long{
    val orderIdNow :Long =System.currentTimeMillis()
    return orderIdNow
}