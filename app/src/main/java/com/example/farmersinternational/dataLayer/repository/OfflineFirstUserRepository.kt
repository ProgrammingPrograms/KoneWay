package com.example.farmersinternational.dataLayer.repository

import com.example.farmersinternational.dataLayer.LocalModel.EntityUser
import com.example.farmersinternational.dataLayer.LocalModel.asExternalModel
import com.example.farmersinternational.dataLayer.dao.UserDao
import com.example.farmersinternational.dataLayer.domainModel.User
import com.example.farmersinternational.dataLayer.domainModel.asEntityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstUserRepository @Inject constructor(private val userDao: UserDao): UserRepository
{
    override suspend fun insertOrIgnoreUser(user: User): Long =
        userDao.insertOrIgnoreUser(user.asEntityModel())

    override suspend fun createOrUpdateUser(user: User): Long =
        userDao.createOrUpdateUser(user.asEntityModel())

    override fun getUserWhoBuying(userId: Long): Flow<User> = //flow list user with Order and product
        userDao.getUserWhoBuying(userId).map { it.asExternalModel()}

    override fun getUsersWhoBuying(userIds: Set<Long>): Flow<List<User>> =
        userDao.getUsersWhoBuying(userIds).map { it.map (EntityUser::asExternalModel) }

    override fun getUserNotification(userId: Long): Flow<User> =
        userDao.getUserNotification(userId).map { it.asExternalModel() }

    override suspend fun deleteUser(userId: Long) =
        userDao.deleteUser(userId)
}