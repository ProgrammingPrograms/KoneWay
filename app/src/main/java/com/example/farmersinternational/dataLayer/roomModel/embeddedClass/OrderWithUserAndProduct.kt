package com.example.farmersinternational.dataLayer.roomModel.embeddedClass

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.model.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.roomModel.EntityOrder
import com.example.farmersinternational.dataLayer.roomModel.EntityProduct
import com.example.farmersinternational.dataLayer.roomModel.EntityUser
import com.example.farmersinternational.dataLayer.roomModel.asExternalModel

data class OrderWithUserAndProductJoin(
    @Embedded val order : EntityOrder,
    @Embedded val user :EntityUser,
    @Embedded val product :EntityProduct
)

fun OrderWithUserAndProductJoin.asExternalModel() = OrderWithUserAndProduct(
    order = order.asExternalModel(),
    user = user.asExternalModel(),
    product = product.asExternalModel()
)
