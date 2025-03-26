package com.example.farmersinternational.DataLayer.ModelEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.farmersinternational.DataLayer.ExternalModel.Order


// Order of user or farmer after they ORder AND WANT TO SEE
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
    val orderId: Long,
    val userId: Long,
    val productId: Long,
    @ColumnInfo(defaultValue = "")
    val price: List<EntityProduct> = emptyList(),
    val date: Long
)
fun EntityOrder.asExternalModel() = Order(
    orderId = orderId,
    userId = userId,
    productId = productId,
    price = price,
    date = date

)