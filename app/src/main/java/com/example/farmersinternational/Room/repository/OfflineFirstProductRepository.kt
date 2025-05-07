package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.Dto.ProductIdAndPhotoDTO
import com.example.farmersinternational.dataLayer.RoomEntity.modelJoins.asExternalModel
import com.example.farmersinternational.dataLayer.RoomEntity.modelJoins.FarmerWithProductJoin
import com.example.farmersinternational.dataLayer.dao.ProductDao
import com.example.farmersinternational.dataLayer.domainModel.Product
import com.example.farmersinternational.dataLayer.domainModel.asEntityModel
import com.example.farmersinternational.dataLayer.domainModel.FarmerWithProduct
import com.example.farmersinternational.dataLayer.RoomEntity.EntityProduct
import com.example.farmersinternational.dataLayer.RoomEntity.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
class OfflineFirstProductRepository @Inject constructor(private val productDao: ProductDao):ProductRepository {

    override suspend fun insertOrIgnoreProduct(product: Product): Long =
        productDao.insertOrIgnorePoduct(product.asEntityModel())


    override suspend fun createOrUpdateProduct(product: Product): Long =
        productDao.createOrUpdateProduct(product.asEntityModel())

    override fun getProductsMainPage(farmerIds: Set<Long>): Flow<List<FarmerWithProduct>> =
        productDao.getProductsMainPage(farmerIds).map {it.map(FarmerWithProductJoin::asExternalModel)}

    override fun getProducts(productIds: Set<Long>): Flow<List<Product>>   =
        productDao.getProducts(productIds).map { it.map(EntityProduct::asExternalModel) }

    override fun getProductSortByFruitsOrVegetables(farmerIds: Set<Long>): Flow<List<FarmerWithProduct>> =
        productDao.getProductSortByVegetables(farmerIds).map { it.map(FarmerWithProductJoin::asExternalModel)}

    override fun updateImageForProduct(farmerId: Long, newUrl: String) =
        productDao.updateImageForProduct(farmerId, newUrl)

        override fun getProductsSortByGmo(farmerIds: Set<Long>, productIds: Set<Long>): Flow<List<FarmerWithProduct>>
        = productDao.getProductsSortByGmo(farmerIds, productIds).map { it.map(FarmerWithProductJoin::asExternalModel) }

    override fun getProductPhoto(productId: Long): Flow<ProductIdAndPhotoDTO>
    = productDao.getProductPhoto(productId)

    override suspend fun deleteProduct(productId: Long) =
        productDao.deleteProduct(productId)
        }
