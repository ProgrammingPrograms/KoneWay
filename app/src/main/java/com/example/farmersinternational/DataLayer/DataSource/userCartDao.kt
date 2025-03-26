package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface userCartDao {

    @Query("SELECT * FROM USERCARTMODEL")
  suspend  fun fetchUserCartData(): Flow<List<userCartModel>>
    //should be main safe suspend

    @Upsert
    suspend  fun upsertUserCartData(UserCartModel : userCartModel)

    @Delete
    suspend fun deleteUserCartData(UserCartModel : userCartModel)
}