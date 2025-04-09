package com.example.farmersinternational.dataLayer.DomainLayer

import com.example.farmersinternational.dataLayer.model.Product
import com.example.farmersinternational.dataLayer.repository.OfflineFirstProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFarmerProductUseCase @Inject constructor(private val offlineFirstProductRepository: OfflineFirstProductRepository) {

     operator fun invoke(farmerIds: Set<Long>): Flow<List<Product>>

}