package com.example.farmersinternational.dataLayer.domainModel

import com.example.farmersinternational.dataLayer.Dto.ProductIdAndPhotoDTO
import com.example.farmersinternational.dataLayer.Dto.UserDTO

data class OrderWithUserAndProduct(
    val orderId:Long,
    val user:UserDTO,
    val product:ProductIdAndPhotoDTO

)
