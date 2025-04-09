package com.example.farmersinternational.dataLayer.RoomModel.EmbeddedClass

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.RoomModel.EntityFarmer
import com.example.farmersinternational.dataLayer.RoomModel.EntityProduct
import com.example.farmersinternational.dataLayer.RoomModel.asExternalModel
import com.example.farmersinternational.dataLayer.model.FarmerWithProduct

class FarmerWithProductJoin(
    @Embedded val farmer: EntityFarmer,
    @Embedded val product: EntityProduct
)
fun FarmerWithProductJoin.asExternalModel() = FarmerWithProduct(
    farmer = farmer.asExternalModel(),
    product = product.asExternalModel()
)