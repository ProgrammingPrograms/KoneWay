package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.DataLayer.DataModel.farmerModel
import kotlinx.coroutines.flow.Flow

@Dao
interface farmerDao {

    @Query("SELECT * FROM FARMERMODEL Where id = :farmerID")
  suspend  fun getById(farmerID: String): Flow<List<farmerModel>>

    @Query("SELECT farmerProfilePhoto, farmerFullName FROM farmerModel")
   suspend fun fetchFarmerSpecificData(): Flow<List<farmerModel>>

    @Upsert
   suspend fun upsertFarmerInformation(FarmerModel: farmerModel)

@Delete
suspend fun deleteFarmerInformation(FarmerModel: farmerModel)


}