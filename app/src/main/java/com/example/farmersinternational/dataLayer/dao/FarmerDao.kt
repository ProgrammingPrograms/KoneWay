package com.example.farmersinternational.Core.Database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnore(entity: EntityFarmer): Long


    @Upsert
    suspend fun createOrUpdateFarmerAccount(entity: EntityFarmer): Long


    @Query("SELECT * FROM" +
            " ENTITYFARMER " +
            "WHERE " +
            "farmerId = :farmerId")
    fun getFarmerById(farmerId: Long): Flow<EntityFarmer>

    @Query("SELECT * FROM " +
            "ENTITYFARMER " +
            "WHERE " +
            "farmerId = (:farmerIds)")
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<EntityFarmer>>



    @Query("SELECT " +
            "imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM " +
            "EntityProduct " +
            "WHERE " +
            "ENTITYPRODUCT.farmerId = :farmerId" +
            " AND farmerId IN " +
            "(SELECT farmerId FROM ENTITYFARMER WHERE ENTITYFARMER.farmerId = :farmerId)")
    fun getFarmersProducts(farmerId: Long): Flow<List<EntityProduct>>

    @Query("SELECT imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM ENTITYPRODUCT " +
            "WHERE ENTITYPRODUCT.farmerId = :farmerId " +
            "AND farmerId IN" +
            "(SELECT farmerId FROM ENTITYFARMER WHERE ENTITYFARMER.farmerId = :farmerId)" +
            "ORDER BY " +
            "ENTITYPRODUCT.isGmo Desc, ENTITYPRODUCT.isOrganic DESC ")
    fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<EntityProduct>>

    @Query("DELETE FROM ENTITYPRODUCT" +
            " WHERE " +
            "ENTITYPRODUCT.productId = :productId" +
            " AND " +
            "ENTITYPRODUCT.farmerId = " +
            "(SELECT ENTITYFARMER.farmerId FROM ENTITYFARMER" +
            " WHERE " +
            "ENTITYFARMER.farmerId = :farmerId)")
  suspend fun removeFarmersProduct(farmerId: Long, productId:Long)

    @Delete
   suspend fun deleteFarmerAccount(farmerId: Long)

}