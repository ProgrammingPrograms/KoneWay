package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.domainModel.Product
import com.example.farmersinternational.dataLayer.domainModel.FarmerWithProduct
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertOrIgnoreProduct(product: Product): Long
    suspend fun createOrUpdateProduct(product: Product): Long
    fun getProducts(productIds: Set<Long>): Flow<List<Product>>
    fun getProductsMainPage(farmerIds: Set<Long>) : Flow<List<FarmerWithProduct>>
    fun getProductSortByFruitsOrVegetables(farmerIds: Set<Long>) : Flow<List<FarmerWithProduct>>
    fun updateImageForProduct(farmerId: Long,newUrl: String)
    fun getProductsSortByGmo(farmerIds: Set<Long>, productIds: Set<Long>): Flow<List<FarmerWithProduct>>

}