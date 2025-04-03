package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.domainmodel.Farmer
import com.example.farmersinternational.Core.domainmodel.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertOrIgnoreProduct(domainModel: Product): Long
    suspend fun createOrUpdateProduct(domainModel: Product): Long
    fun getProductsMainPage(farmerIds: Set<Long>) : Flow<Map<List<Farmer>, List<Product>>>
    fun getProduceSortedByFruitsOrVegetables(farmerIds: Set<Long>) : Flow<Map<List<Farmer>, List<Product>>>
    fun updateImageForProduct(farmerId: Long,newUrl: String)
    fun getProductsSortByGmo(farmerIds: Set<Long>, productIds: Set<Long>): Flow<Map<List<Farmer>, List<Product>>>

}//this is what is interacting with the ui the repository repositories dont have etities for extra seperation of concerns