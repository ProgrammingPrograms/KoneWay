package com.example.farmersinternational.Core.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.Core.ModelEntity.EntityUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUser(entity: EntityUser):Long


    @Upsert
    fun CreateOrUpdateUser(entity: EntityUser): Long
    //all creates check and see

    @Query("SELECT " +
            "userOnFootOnBikeOnCar, profilePhoto, fullName" +
            " FROM ENTITYUSER " +
            "WHERE userId = :userId")
    fun getUserWhoGoingToFarmer(userId: Long): Flow<EntityUser>


    @Query("SELECT " +
            "userOnFootOnBikeOnCar, profilePhoto" +
            " FROM ENTITYUSER" +
            " WHERE userId = (:userIds) ")
    fun  getMultiUsersWhoGoingToFarmer(userIds: Set<Long>): Flow<List<EntityUser>>

    @Query("SELECT " +
            "notification " +
            "FROM ENTITYUSER " +
            "WHERE userId = :userId")
    fun getUserNotification(userId: Long):Flow<EntityUser>

   @Delete
    fun deleteUser(userId: Long)


}