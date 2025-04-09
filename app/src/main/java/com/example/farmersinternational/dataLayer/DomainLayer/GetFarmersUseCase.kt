package com.example.farmersinternational.dataLayer.DomainLayer

import com.example.farmersinternational.dataLayer.model.Farmer
import com.example.farmersinternational.dataLayer.model.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstFarmersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleFarmerUseCase @Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository){

    operator fun invoke(farmerId: Long): Flow<Farmer>  =
         offlineFirstFarmersRepository.getFarmerById(farmerId)

    }
class GetMultipleFarmersUseCase @Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository){

    operator fun invoke(farmerIds: Set<Long>): Flow<List<Farmer>> =
        offlineFirstFarmersRepository.getFarmersByIds(farmerIds)

}

class GetFarmersProductsUseCase @Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository) {

    operator fun invoke(farmerId: Long): Flow<List<Product>> =
        offlineFirstFarmersRepository.getFarmersProducts(farmerId)
}

class GetFarmersProductsSortedByGmoUseCase @Inject constructor(private val offlineFirstFarmersRepository: OfflineFirstFarmersRepository) {

    operator fun invoke(farmerId: Long): Flow<List<Product>> =
        offlineFirstFarmersRepository.getFarmersProductsSortedByGmo(farmerId)
}


