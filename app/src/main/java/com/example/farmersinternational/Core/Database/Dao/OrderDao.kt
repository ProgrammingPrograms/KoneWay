package com.example.farmersinternational.Core.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.Core.ModelEntity.EntityOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertOrIgnoreOrder(entity: EntityOrder): Long//if same primary key

   @Upsert
   fun CreateOrUpdateOrder(entity: EntityOrder):Long

   @Query("SELECT * FROM" +
           " ENTITYORDER " +
           "WHERE " +
           "ENTITYORDER.userId IN " +
           "(SELECT userId FROM ENTITYUSER WHERE ENTITYUSER.userId = :userId)")
   fun getUserOrder(userId: Long): Flow<EntityOrder>

   @Delete
   fun deleteUserOrder(orderId: Long)


}