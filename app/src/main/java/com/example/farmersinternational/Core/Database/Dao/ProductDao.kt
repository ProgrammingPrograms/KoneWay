package com.example.farmersinternational.Core.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.Core.ModelEntity.EntityFarmer
import com.example.farmersinternational.Core.ModelEntity.EntityProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertOrIgnorePoduct(entity: EntityProduct): Long

    @Upsert
    fun createOrUpdateProduct(entity: EntityProduct): Long


    @Query("SELECT " +
            "ENTITYFARMER.profilePhoto,EntityProduct.name,ENTITYPRODUCT.imageUrl, EntityProduct.isOrganic," +
            " EntityProduct.isGmo, EntityProduct.isOrganic  " +
            "FROM ENTITYFARMER " +
            "INNER JOIN ENTITYPRODUCT " +
            "ON " +
            "ENTITYFARMER.farmerId = EntityProduct.farmerId" +
            " WHERE ENTITYFARMER.farmerId IN (:farmerIds) ")
    fun getProductsMainPage(farmerIds: Set<Long>) : Flow<Map<List<EntityFarmer>, List<EntityProduct>>>


    @Query("SELECT" +
            " ENTITYPRODUCT.imageUrl,ENTITYPRODUCT.name,ENTITYPRODUCT.isGmo,ENTITYPRODUCT.isOrganic, ENTITYFARMER.profilePhoto" +
            " FROM ENTITYPRODUCT " +
            "INNER JOIN ENTITYFARMER " +
            "ON ENTITYPRODUCT.farmerId = ENTITYFARMER.farmerId WHERE ENTITYFARMER.farmerId IN (:farmerIds)" +
            "ORDER BY " +
            "ENTITYPRODUCT.fruitOrVegetable DESC")
    fun getProduceSortedByFruitsOrVegetables(farmerIds: Set<Long>) : Flow<Map<List<EntityFarmer>, List<EntityProduct>>>


    @Query("UPDATE" +
            " ENTITYPRODUCT " +
            "SET imageUrl = :newUrl " +
            "WHERE ENTITYPRODUCT.farmerId = :farmerId " +
            "AND ENTITYPRODUCT.farmerId " +
            "IN (SELECT ENTITYFARMER.farmerId FROM ENTITYFARMER " +
            "WHERE ENTITYFARMER.farmerId = farmerId)")
    fun updateImageForProduct(farmerId: Long,newUrl: String)


    @Query("SELECT " +
            "ENTITYFARMER.profilePhoto,ENTITYPRODUCT.isGMO," +
            "ENTITYPRODUCT.isOrganic, ENTITYPRODUCT.imageUrl" +
            " FROM ENTITYFARMER " +
            "INNER JOIN ENTITYPRODUCT" +
            " ON ENTITYFARMER.farmerId = ENTITYPRODUCT.farmerId" +
            " WHERE ENTITYFARMER.farmerId " +
            "IN (:farmerIds) " +
            "AND ENTITYPRODUCT.productId " +
            "IN (:productIds)" +
            "ORDER BY " +
            "ENTITYPRODUCT.IsGmo DESC," +
            "ENTITYPRODUCT.IsOrganic DESC ")
    fun getProductsSortByGmo(farmerIds: Set<Long>, productIds: Set<Long>): Flow<Map<List<EntityFarmer>, List<EntityProduct>>>
}