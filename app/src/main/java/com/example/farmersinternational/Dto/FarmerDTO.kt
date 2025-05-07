package com.example.farmersinternational.Dto

import androidx.room.ColumnInfo

data class FarmerHomePageDTO(
    @ColumnInfo(name = "profilePhoto") val profilePhoto: String,
    @ColumnInfo(name = "farmerId") val farmerId: Long
)


/*
 @Query("SELECT " +
            "ENTITYFARMER.profilePhoto,ENTITYPRODUCT.isGMO," +
            "ENTITYPRODUCT.isOrganic, ENTITYPRODUCT.imageUrl" +
            " FROM ENTITYFARMER " +
            "INNER JOIN ENTITYPRODUCT" +
            " ON ENTITYFARMER.farmerId = ENTITYPRODUCT.farmerId" +
            " WHERE ENTITYFARMER.farmerId " +
            "IN (:farmerIds) " +
            "AND ENTITYPRODUCT.productId " +
            "IN (:productIds)" +
            "ORDER BY " +
            "ENTITYPRODUCT.IsGmo DESC," +
            "ENTITYPRODUCT.IsOrganic DESC ")//skip for now
 */