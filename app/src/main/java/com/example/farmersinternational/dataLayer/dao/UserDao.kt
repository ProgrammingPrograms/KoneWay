package com.example.farmersinternational.dataLayer.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.dataLayer.LocalModel.EntityUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUser(entity: EntityUser):Long


    @Upsert
    suspend fun createOrUpdateUser(entity: EntityUser): Long

    @Query("SELECT " +
            "userOnFootOnBikeOnCar, profilePhoto, fullName" +
            " FROM ENTITYUSER " +
            "WHERE userId = :userId")
    fun getUserWhoBuying(userId: Long): Flow<EntityUser>


    @Query("SELECT " +
            "userOnFootOnBikeOnCar, profilePhoto" +
            " FROM ENTITYUSER" +
            " WHERE userId = (:userIds) ")
    fun  getUsersWhoBuying(userIds: Set<Long>): Flow<List<EntityUser>>

    @Query("SELECT " +
            "notification " +
            "FROM ENTITYUSER " +
            "WHERE userId = :userId")
    fun getUserNotification(userId: Long):Flow<EntityUser>

   @Delete
    suspend fun deleteUser(userId: Long)


}