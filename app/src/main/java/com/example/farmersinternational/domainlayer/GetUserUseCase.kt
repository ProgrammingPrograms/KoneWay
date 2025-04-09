package com.example.farmersinternational.dataLayer.DomainLayer

import com.example.farmersinternational.dataLayer.model.User
import com.example.farmersinternational.dataLayer.repository.OfflineFirstOrderRepository
import com.example.farmersinternational.dataLayer.repository.OfflineFirstUserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserWhoGoingToFarmerUseCase @Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository) {
    operator fun invoke(userId:Long):Flow<User> =
        offlineFirstUserRepository.getUserWhoGoingToFarmer(userId)
}
class GetMultiUsersWhoGoingToFarmerCase @Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository) {
    operator fun invoke(userIds:Set<Long>):Flow<User> =
        offlineFirstUserRepository.getMultiUsersWhoGoingToFarmer(userIds)
}

class GetUserNotification @Inject constructor(private val offlineFirstUserRepository: OfflineFirstUserRepository) {
    operator fun invoke(userId: Long): Flow<User> =
        offlineFirstUserRepository.getUserNotification(userId)
}