package com.example.farmersinternational.dataLayer.RoomEntity.modelJoins

import androidx.room.Embedded
import com.example.farmersinternational.dataLayer.RoomEntity.EntityFarmer
import com.example.farmersinternational.dataLayer.RoomEntity.EntityProduct
import com.example.farmersinternational.dataLayer.RoomEntity.asExternalModel
import com.example.farmersinternational.dataLayer.domainModel.FarmerWithProduct

class FarmerWithProductJoin(
    @Embedded val farmer: EntityFarmer,
    @Embedded val product: EntityProduct
)
fun FarmerWithProductJoin.asExternalModel() = FarmerWithProduct(
    farmer = farmer.asExternalModel(),
    product = product.asExternalModel()
)