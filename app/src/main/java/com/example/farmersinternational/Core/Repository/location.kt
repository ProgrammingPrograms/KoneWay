package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.FarmerDao
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.Database.model.asExternalModel
import com.example.farmersinternational.Core.model.Farmer
import com.example.farmersinternational.Core.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstFarmersRepository @Inject constructor(private val farmerdao: FarmerDao): farmerRepository {

//class impl

    override fun getFarmerById(farmerId: Long): Flow<Farmer> =
        farmerdao.getFarmerById(farmerId).map {
            it.asExternalModel()
        }
    override fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<Farmer>> =
        farmerdao.getFarmersByIds(farmerIds).map {
            it.map(EntityFarmer::asExternalModel)
        }//afterward see weather or not the double mappping is due to the double<> in list

    override fun getFarmersProducts(farmerId: Long):Flow<List<Product>> =
        farmerdao.getFarmersProducts(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }
//m                                                               map targets the list itmap. means you need to map each element in the list
    override fun getFarmersProductsSortedByGmo(farmerId: Long): Flow<List<Product>> =
        farmerdao.getFarmersProductsSortedByGmo(farmerId).map {
            it.map(EntityProduct::asExternalModel)
        }
    //inserts + deletes /yaeh exactly what i thought. so you need to map each element in the list/ ask about the coworking spaces


    override suspend fun insertOrIgnore(model: Farmer): Long =
        farmerdao.insertOrIgnore(model)//do inserts later
//upsert insert and delete

}
