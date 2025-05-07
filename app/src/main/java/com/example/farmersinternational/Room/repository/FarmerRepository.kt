package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.domainModel.Farmer
import com.example.farmersinternational.dataLayer.domainModel.Product
import kotlinx.coroutines.flow.Flow

interface FarmerRepository {

    suspend fun insertOrIgnore(farmer: Farmer): Long
   suspend fun createOrUpdateFarmerAccount(farmer: Farmer): Long
    fun getFarmerById(farmerId: Long): Flow<Farmer>
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>>
    fun getFarmersProducts(farmerId: Long): Flow<List<Product>>
    fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>>
    suspend fun removeFarmersProduct(farmerId: Long, productId:Long)
    suspend fun deleteFarmerAccount(farmerId: Long)

}