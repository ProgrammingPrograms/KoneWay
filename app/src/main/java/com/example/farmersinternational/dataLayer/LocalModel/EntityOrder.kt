package com.example.farmersinternational.dataLayer.roomModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.dataLayer.model.Order



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
    @PrimaryKey(autoGenerate = true)
    val orderId: Long? = null,
    val userId: Long?= null,
    val productId: Long?= null,
    @ColumnInfo(defaultValue = "")
    val price: Double,
    val date: Long?= null
)
fun EntityOrder.asExternalModel() = Order(
    orderId = orderId,
    userId = userId,
    productId = productId,
    price = price,
    date = date

)
