package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.DataLayer.DataModel.userCartModel
import kotlinx.coroutines.flow.Flow

interface userCartDataSource {

    @Query("SELECT * FROM USERCARTMODEL")
  suspend  fun fetchUserCartData(): Flow<List<userCartModel>>
    //should be main safe suspend

    @Upsert
    suspend  fun upsertUserCartData(UserCartModel : userCartModel)

    @Delete
    suspend fun deleteUserCartData(UserCartModel : userCartModel)
}