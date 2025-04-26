package com.example.farmersinternational.dataLayer.LocalModel.modelJoins

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.domainModel.OrderWithUserAndProduct
import com.example.farmersinternational.dataLayer.LocalModel.EntityOrder
import com.example.farmersinternational.dataLayer.LocalModel.EntityProduct
import com.example.farmersinternational.dataLayer.LocalModel.EntityUser
import com.example.farmersinternational.dataLayer.LocalModel.asExternalModel

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
