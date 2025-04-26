package com.example.farmersinternational.dataLayer.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.dataLayer.LocalModel.EntityOrder
import com.example.farmersinternational.dataLayer.LocalModel.modelJoins.OrderWithUserAndProductJoin
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

   @Query("SELECT " +
           "ENTITYPRODUCT.imageUrl, " +
           "ENTITYORDER.orderId," +
           " ENTITYUSER.profilePhoto " +
           "FROM ENTITYPRODUCT " +
           "INNER JOIN ENTITYORDER ON ENTITYORDER.productId = ENTITYPRODUCT.productId" +
           " INNER JOIN ENTITYUSER ON ENTITYUSER.userId = ENTITYORDER.userId " +
           "WHERE ENTITYORDER.orderId = :orderId")
   fun getOrderSummary(orderId: Long): Flow<OrderWithUserAndProductJoin>

   @Query(
      "SELECT ENTITYPRODUCT.imageurl," +
              " ENTITYORDER.orderId," +
              "ENTITYUSER.profilePhoto" +
              " FROM " +
              "ENTITYPRODUCT" +
              " INNER JOIN ENTITYORDER ON ENTITYORDER.productId = ENTITYPRODUCT.productId " +
              "INNER JOIN ENTITYUSER ON ENTITYUSER.userId = ENTITYORDER.userId WHERE ENTITYORDER.orderId IN (:orderIds)")
   fun getOrdersSummary(orderIds: Set<Long>): Flow<List<OrderWithUserAndProductJoin>>


   @Delete
  suspend fun deleteUserOrder(orderId: Long)


}