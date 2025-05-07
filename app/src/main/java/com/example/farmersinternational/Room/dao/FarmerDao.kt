package com.example.farmersinternational.dataLayer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.dataLayer.RoomEntity.EntityFarmer
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnore(entity: EntityFarmer): Long


    @Upsert
    suspend fun createOrUpdateFarmerAccount(entity: EntityFarmer): Long

    @Query("SELECT farmerId FROM ENTITYFARMER WHERE farmerId = :farmerId")
    fun getFarmerId(farmerId: Long): Flow<String> //

    @Query("SELECT profilePhoto FROM ENTITYFARMER WHERE farmerId = farmerId")
    fun getFarmersProfilePhotos(farmerId: Long): Flow<String>

    @Query("SELECT * FROM" +
            " ENTITYFARMER " +
            "WHERE " +
            "farmerId = :farmerId")
    fun getFarmerById(farmerId: Long): Flow<EntityFarmer> //

    @Query("SELECT * FROM " +
            "ENTITYFARMER " +
            "WHERE " +
            "farmerId = (:farmerIds)")
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<EntityFarmer>>


    @Query("DELETE FROM ENTITYPRODUCT" +
            " WHERE " +
            "ENTITYPRODUCT.productId = :productId" +
            " AND " +
            "ENTITYPRODUCT.farmerId = " +
            "(SELECT ENTITYFARMER.farmerId FROM ENTITYFARMER" +
            " WHERE " +
            "ENTITYFARMER.farmerId = :farmerId)")
  suspend fun removeFarmersProduct(farmerId: Long, productId:Long)

    @Query("DELETE FROM ENTITYFARMER WHERE farmerId = :farmerId")
   suspend fun deleteFarmerAccount(farmerId: Long)

}