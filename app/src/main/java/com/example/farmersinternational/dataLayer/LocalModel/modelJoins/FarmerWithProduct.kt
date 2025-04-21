package com.example.farmersinternational.dataLayer.roomModel.embeddedClass

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.roomModel.EntityFarmer
import com.example.farmersinternational.dataLayer.roomModel.EntityProduct
import com.example.farmersinternational.dataLayer.roomModel.asExternalModel
import com.example.farmersinternational.dataLayer.model.FarmerWithProduct

class FarmerWithProductJoin(
    @Embedded val farmer: EntityFarmer,
    @Embedded val product: EntityProduct
)
fun FarmerWithProductJoin.asExternalModel() = FarmerWithProduct(
    farmer = farmer.asExternalModel(),
    product = product.asExternalModel()
)