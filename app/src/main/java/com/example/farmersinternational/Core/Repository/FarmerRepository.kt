package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.model.Farmer
import com.example.farmersinternational.Core.model.Product
import kotlinx.coroutines.flow.Flow

interface farmerRepository {

    suspend fun insertOrIgnore(modelFarmer: Farmer): Long
   suspend fun createOrUpdateFarmerAccount(modelFarmer: Farmer): Long
    fun getFarmerById(farmerId: Long): Flow<Farmer>
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>>
    fun getFarmersProducts(farmerId: Long): Flow<List<Product>>
    fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>>
    suspend fun removeFarmersProduct(farmerId: Long, productId:Long)
    suspend fun deleteFarmerAccount(farmerId: Long)

}