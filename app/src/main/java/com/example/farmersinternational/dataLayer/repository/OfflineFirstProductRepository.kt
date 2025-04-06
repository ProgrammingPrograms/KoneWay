package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.ProductDao
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.Database.model.asExternalModel
import com.example.farmersinternational.Core.domainmodel.Farmer
import com.example.farmersinternational.Core.domainmodel.Product
import com.example.farmersinternational.Core.domainmodel.asEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
//specifies weather or not its offline or online
class OfflineFirstProductRepository @Inject constructor(private val productDao: ProductDao):ProductRepository {

    override suspend fun insertOrIgnoreProduct(domainModel: Product): Long =
        productDao.insertOrIgnorePoduct(domainModel.asEntityModel())


    override suspend fun createOrUpdateProduct(domainModel: Product): Long =
        productDao.createOrUpdateProduct(domainModel.asEntityModel())

    override fun getProductsMainPage(farmerIds: Set<Long>): Flow<Map<List<Farmer>, List<Product>>> =
        productDao.getProductsMainPage(farmerIds).map {
map -> mapOf(
    
)
        }

    override fun getProduceSortedByFruitsOrVegetables(far
}merIds: Set<Long>): Flow<Map<List<Farmer>, List<Product>>> {productDao

    override fun updateImageForProduct(farmerId: Long, newUrl: String) {
        productDao

        override fun getProductsSortByGmo(
            farmerIds: Set<Long>,
            productIds: Set<Long>,
        ): Flow<Map<List<Farmer>, List<Product>>> {
            productDao

        }
    }