package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.domainmodel.Farmer
import com.example.farmersinternational.Core.domainmodel.Product
import kotlinx.coroutines.flow.Flow

interface FarmerRepository {

    suspend fun insertOrIgnore(modelFarmer: Farmer): Long
   suspend fun createOrUpdateFarmerAccount(modelFarmer: Farmer): Long
    fun getFarmerById(farmerId: Long): Flow<Farmer>
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>>
    fun getFarmersProducts(farmerId: Long): Flow<List<Product>>
    fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>>
    suspend fun removeFarmersProduct(farmerId: Long, productId:Long)
    suspend fun deleteFarmerAccount(farmerId: Long)

}