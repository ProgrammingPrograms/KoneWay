package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.DataLayer.DataModel.farmerPostModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//data source fetch data from database or

//what is it supposed to do and  what information does it need
//think of real world scenarios

@Dao
interface farmerPostDataSource {
    //should be main safe suspend
@Query("SELECT * FROM farmerPostModel ")
   suspend fun fetchFarmerPostData(): Flow<List<farmerPostModel>>

    @Query("SELECT postPhoto, isGmo, isOrganic FROM farmerPostModel")
   suspend fun fetchFarmerPostSpecific(): Flow<List<farmerPostModel>>

    @Upsert
    suspend  fun upsertUserPostData(FarmerPostModel: farmerPostModel)

@Delete
suspend fun deleteFarmerPostData(FarmerPostModel: farmerPostModel)
//he looked at whats the most simple amount of information you need
    //M.E.N.T.A.L                    R.E.P.R.E.S.E.N.T.A.T.I.O.N.S
//TO GET TASK DONE
}