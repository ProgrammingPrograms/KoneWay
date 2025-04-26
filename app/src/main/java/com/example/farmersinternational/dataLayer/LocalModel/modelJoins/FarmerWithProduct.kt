package com.example.farmersinternational.dataLayer.LocalModel.modelJoins

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.LocalModel.EntityFarmer
import com.example.farmersinternational.dataLayer.LocalModel.EntityProduct
import com.example.farmersinternational.dataLayer.LocalModel.asExternalModel
import com.example.farmersinternational.dataLayer.domainModel.FarmerWithProduct

class FarmerWithProductJoin(
    @Embedded val farmer: EntityFarmer,
    @Embedded val product: EntityProduct
)
fun FarmerWithProductJoin.asExternalModel() = FarmerWithProduct(
    farmer = farmer.asExternalModel(),
    product = product.asExternalModel()
)