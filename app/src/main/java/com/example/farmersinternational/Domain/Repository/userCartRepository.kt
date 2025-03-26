package com.example.farmersinternational.Domain.Repository

import android.content.Context
import com.example.farmersinternational.DataLayer.DataModel.appDatabase

class userCartRepository(private val Appdatabase: appDatabase, context: Context) {

    val cartDataSource = appDatabase.getDatabase(context).getUserCartDataSource()

   suspend fun fetchUserCartInformation() = cartDataSource.fetchUserCartData()

    suspend fun upsertUserCartData(UserCartModel : userCartModel){
        cartDataSource.upsertUserCartData(UserCartModel)

        suspend fun deleteUserCartData(){
            cartDataSource.deleteUserCartData(userCartModel())
        }

    }
}