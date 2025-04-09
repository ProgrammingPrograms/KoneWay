package com.example.farmersinternational.dataLayer.DomainLayer

import com.example.farmersinternational.dataLayer.model.FarmerWithProduct
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFarmerWithProductuseCase @Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository){

operator fun invoke(farmerIds: Set<Long>): Flow<List<FarmerWithProduct>>  =
    offlineFirstProductRepository.getProductsMainPage(farmerIds)

}
class GetFarmersWithProductsSortedByFruitsOrVegetables @Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository) {

operator fun invoke(farmerIds: Set<Long>): Flow<List<FarmerWithProduct>> =
    offlineFirstProductRepository.getProductSortByFruitsOrVegetables(farmerIds)
}

class GetFarmersWithProductsSortByGmo @Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository) {

    operator fun invoke(farmerIds: Set<Long>,productIds: Set<Long>): Flow<List<FarmerWithProduct>> =
        offlineFirstProductRepository.getProductsSortByGmo(farmerIds, productIds)
}