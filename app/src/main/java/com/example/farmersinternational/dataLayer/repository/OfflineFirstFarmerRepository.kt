package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.FarmerDao
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.Database.model.asExternalModel
import com.example.farmersinternational.Core.domainmodel.Farmer
import com.example.farmersinternational.Core.domainmodel.Product
import com.example.farmersinternational.Core.domainmodel.asEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
// entity dao, repo of screen farmer screen
// use case
//ui

class OfflineFirstFarmersRepository @Inject constructor(private val farmerdao: FarmerDao): FarmerRepository {

override suspend fun insertOrIgnore(modelFarmer: Farmer): Long =
        farmerdao.insertOrIgnore(modelFarmer.asEntityModel())

    override suspend fun createOrUpdateFarmerAccount(modelFarmer: Farmer): Long =
        farmerdao.createOrUpdateFarmerAccount(modelFarmer.asEntityModel())

    override fun getFarmerById(farmerId: Long): Flow<Farmer> =
        farmerdao.getFarmerById(farmerId).map {
            it.asExternalModel()
        }
    override fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>> =
        farmerdao.getFarmersByIds(farmerIds).map {
            it.map(EntityFarmer::asExternalModel)
        }

    override fun getFarmersProducts(farmerId: Long):Flow<List<Product>> =
        farmerdao.getFarmersProducts(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }

    override fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>> =
        farmerdao.getFarmersProductsSortedByGmo(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }

    override suspend fun removeFarmersProduct(farmerId: Long, productId: Long) =
        farmerdao.removeFarmersProduct(farmerId,productId)

    override suspend fun deleteFarmerAccount(farmerId: Long) =
        farmerdao.deleteFarmerAccount(farmerId)
}
