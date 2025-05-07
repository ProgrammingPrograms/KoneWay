package com.example.farmersinternational.dataLayer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.dataLayer.Dto.ProductIdAndPhotoDTO
import com.example.farmersinternational.dataLayer.Dto.ProductsForFarmersPageDTO
import com.example.farmersinternational.dataLayer.Dto.ProductsHomePageDTO
import com.example.farmersinternational.dataLayer.Dto.ProductsIsFruitTuple
import com.example.farmersinternational.dataLayer.Dto.ProductsIsTuple
import com.example.farmersinternational.dataLayer.Dto.ProductsToSorByGmoDTO
import com.example.farmersinternational.dataLayer.RoomEntity.EntityProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertOrIgnorePoduct(entity: EntityProduct): Long

    @Upsert
   suspend fun createOrUpdateProduct(entity: EntityProduct): Long

    @Query("UPDATE" + //have business logic for all?
            " ENTITYPRODUCT " +
            "SET imageUrl = :newUrl " +
            "WHERE ENTITYPRODUCT.farmerId = :farmerId " +
            "AND ENTITYPRODUCT.farmerId " +
            "IN (SELECT ENTITYFARMER.farmerId FROM ENTITYFARMER " +
            "WHERE ENTITYFARMER.farmerId = :farmerId)")
    fun updateImageForProduct(farmerId: Long,newUrl: String)

    @Query("SELECT " +
            "farmerId, imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM " +
            "EntityProduct")
        fun getProductsForFarmers(farmerId: Long):Flow<List<ProductsForFarmersPageDTO>>

    @Query("SELECT imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM ENTITYPRODUCT ")
    fun getProductsToSortByGmo(farmerId: Long): Flow<ProductsToSorByGmoDTO>

    @Query("SELECT imageUrl,name,isOrganic,isGmo FROM ENTITYPRODUCT WHERE productId IN (:productIds)")
    fun getProducts(productIds: Set<Long>): Flow<List<EntityProduct>>

    @Query("SELECT farmerId, name, imageUrl, isOrganic, isGmo FROM ENTITYPRODUCT")
    fun getProductsHomePage(productIds: Set<Long>): Flow<List<ProductsHomePageDTO>>
//3 steps
    //fix
    //refactor
    //refactor DEEPLY

    @Query("SELECT" +
            " ENTITYPRODUCT.imageUrl,ENTITYPRODUCT.name,ENTITYPRODUCT.isGmo,ENTITYPRODUCT.isOrganic, ENTITYPRODUCT.fruitOrVegetable" +
            " FROM ENTITYPRODUCT ")
    fun getProductSortByVegetables(farmerId: Long) : Flow<ProductsIsFruitTuple>


    @Query("SELECT + ENTITYPRODUCT.isGMO," +
            "ENTITYPRODUCT.isOrganic, ENTITYPRODUCT.imageUrl" +
            " FROM ENTITYPRODUCT " )
    fun getProductIs(farmerIds: Set<Long>, productIds: Set<Long>): Flow<ProductsIsTuple>


    @Query("SELECT imageUrl, productId FROM ENTITYPRODUCT WHERE productId = :productId")
    fun getProductPhoto(productId: Long): Flow<ProductIdAndPhotoDTO>



    @Query("DELETE FROM ENTITYPRODUCT WHERE productId = :productId")
  suspend fun deleteProduct(productId: Long)

}