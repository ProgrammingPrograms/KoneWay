package com.example.farmersinternational.dataLayer.RoomEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.dataLayer.domainModel.Order
import kotlinx.datetime.Instant


@Entity(tableName = "EntityOrder", foreignKeys = [
    ForeignKey(entity = EntityUser::class,
        parentColumns = ["userId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE),
ForeignKey(entity = EntityProduct::class,
    parentColumns = ["productId"],
    childColumns = ["productId"],
    onDelete = ForeignKey.CASCADE)])

data class EntityOrder(
    @PrimaryKey(autoGenerate = false)
    val orderId: Long? = null,
    val userId: Long?= null,
    val productId:  Long? = null, //lets you skip this value when creating the object  but itmeans nothing for room
    @ColumnInfo(defaultValue = "0")
    val price: Int,
    val date: Instant?= null
)
fun EntityOrder.asExternalModel() = Order(
    orderId = orderId,
    userId = userId,
    productId = productId,
    price = price,
    date = date

)
