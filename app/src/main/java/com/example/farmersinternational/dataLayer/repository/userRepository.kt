package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.domainModel.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertOrIgnoreUser(user: User):Long
    suspend fun createOrUpdateUser(user: User): Long
    fun getUserWhoBuying(userId: Long): Flow<User>
    fun  getUsersWhoBuying(userIds: Set<Long>): Flow<List<User>>
    fun getUserNotification(userId: Long):Flow<User>
    suspend fun deleteUser(userId: Long)

}