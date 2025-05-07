package com.example.farmersinternational.dataLayer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.dataLayer.RoomEntity.EntityOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertOrIgnoreOrder(entity: EntityOrder): Long//if same primary key

   @Upsert
   suspend fun createOrUpdateOrder(entity: EntityOrder):Long

   @Query("SELECT * FROM" +
           " ENTITYORDER " +
           "WHERE " +
           "ENTITYORDER.userId IN " +
           "(SELECT userId FROM ENTITYUSER WHERE ENTITYUSER.userId = :userId)")
   fun getUserOrder(userId: Long): Flow<EntityOrder>

   @Query("SELECT orderId FROM ENTITYORDER WHERE orderId = :orderId")
   fun getOrderId(orderId: Long):Flow<Long>

   @Query("DELETE FROM ENTITYORDER WHERE orderId = :orderId")
  suspend fun deleteUserOrder(orderId: Long)


}