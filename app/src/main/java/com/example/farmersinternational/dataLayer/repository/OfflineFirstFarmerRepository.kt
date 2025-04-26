package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.dao.FarmerDao
import com.example.farmersinternational.dataLayer.LocalModel.EntityFarmer
import com.example.farmersinternational.dataLayer.LocalModel.EntityProduct
import com.example.farmersinternational.dataLayer.LocalModel.asExternalModel
import com.example.farmersinternational.dataLayer.domainModel.Farmer
import com.example.farmersinternational.dataLayer.domainModel.Product
import com.example.farmersinternational.dataLayer.domainModel.asEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
// entity dao, repo of screen farmer screen
// use case
//ui

class OfflineFirstFarmersRepository @Inject constructor(private val farmerdao: FarmerDao): FarmerRepository {

override suspend fun insertOrIgnore(farmer: Farmer): Long =
        farmerdao.insertOrIgnore(farmer.asEntityModel())

    override suspend fun createOrUpdateFarmerAccount(farmer: Farmer): Long =
        farmerdao.createOrUpdateFarmerAccount(farmer.asEntityModel())

    override fun getFarmerById(farmerId: Long): Flow<Farmer> =
        farmerdao.getFarmerById(farmerId).map {
            it.asExternalModel()
        }
    override fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>> =
        farmerdao.getFarmersByIds(farmerIds).map {
            it.map(EntityFarmer::asExternalModel)
        }

    override fun getFarmersProducts(farmerId: Long):Flow<List<Product>> = //getproductsusecase depends on this
        farmerdao.getFarmersProducts(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }

    override fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>> = //sowillthis
        farmerdao.getFarmersProductsSortedByGmo(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }

    override suspend fun removeFarmersProduct(farmerId: Long, productId: Long) =
        farmerdao.removeFarmersProduct(farmerId,productId)

    override suspend fun deleteFarmerAccount(farmerId: Long) =
        farmerdao.deleteFarmerAccount(farmerId)
}
