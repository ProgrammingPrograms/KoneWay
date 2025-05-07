package com.example.farmersinternational.Dto

import androidx.room.ColumnInfo

data class ProductIdAndPhotoDTO(
    @ColumnInfo(name = "productId") val productId: Long,
    @ColumnInfo(name = "imageUrl") val imageUrl: String
)
data class ProductsHomePageDTO (
    @ColumnInfo(name = "farmerId") val farmerId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "isOrganic") val isOrganic: Boolean,
    @ColumnInfo(name = "isGmo") val isGmo: Boolean
)
/*
("SELECT " +//not sorts yet just stuff like this
            "ENTITYFARMER.profilePhoto,EntityProduct.name,ENTITYPRODUCT.imageUrl, EntityProduct.isOrganic," +
            " EntityProduct.isGmo  " + //entityfarmer
            "FROM ENTITYFARMER " +
            "INNER JOIN ENTITYPRODUCT " +
            "ON " +
            "ENTITYFARMER.farmerId = EntityProduct.farmerId" +
            " WHERE ENTITYFARMER.farmerId IN (:farmerIds) ")
 */

data class ProductsForFarmersPageDTO(
    @ColumnInfo(name = "farmerId") val farmerId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "isOrganic") val isOrganic: Boolean,
    @ColumnInfo(name = "isGmo") val isGmo: Boolean
    /*
     @Query("SELECT " +//productDTO + ProductDAO + farmerDao returns a string = 2903
            "imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM " +
            "EntityProduct " +
            "WHERE " +
            "ENTITYPRODUCT.farmerId = :farmerId" +
            " AND farmerId IN " +
            "(SELECT farmerId FROM ENTITYFARMER WHERE ENTITYFARMER.farmerId = :farmerId)")
     */

)
data class ProductsToSorByGmoDTO(//and organic, from farmers
    @ColumnInfo(name = "farmerId") val farmerId: Long,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "isGmo") val isGmo: Boolean,
    @ColumnInfo(name = "isOrganic") val isOrganic: Boolean,
    @ColumnInfo(name = "isGrownIn") val isGrownIn: String)
/*
 @Query("SELECT imageUrl,name,price,description,isGmo,isOrganic,isGrownIn " +
            "FROM ENTITYPRODUCT " +
            "WHERE ENTITYPRODUCT.farmerId = :farmerId " +
            "AND farmerId IN" + //227
            "(SELECT farmerId FROM ENTITYFARMER WHERE ENTITYFARMER.farmerId = :farmerId)" +
            "ORDER BY " +
            "ENTITYPRODUCT.isGmo Desc, ENTITYPRODUCT.isOrganic DESC ")
 */

data class ProductsIsTuple(
    @ColumnInfo(name = "isOrganic") val isOrganic: Boolean,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "farmerId") val farmerId:Long,
    @ColumnInfo(name = "isGMO") val isGMO: Boolean)

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

data class ProductsIsFruitTuple(//and organic, from farmers
    @ColumnInfo(name = "isOrganic") val isOrganic: Boolean,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "farmerId") val farmerId: Long,
@ColumnInfo(name = "isGMO") val isGMO: Boolean,
@ColumnInfo(name = "fruitOrVegetable") val fruitOrVegetable: Boolean)
        /*
        @Query("SELECT" +
            " ENTITYPRODUCT.imageUrl,ENTITYPRODUCT.name,ENTITYPRODUCT.isGmo,ENTITYPRODUCT.isOrganic, ENTITYFARMER.profilePhoto" +
            " FROM ENTITYPRODUCT " +
            "INNER JOIN ENTITYFARMER " +
            "ON ENTITYPRODUCT.farmerId = ENTITYFARMER.farmerId WHERE ENTITYFARMER.farmerId IN (:farmerIds)" +
            "ORDER BY " +
            "ENTITYPRODUCT.fruitOrVegetable DESC")
    fun getProductSortByVegetables(farmerIds: Set<Long>) : Flow<ProductsIsFruitTuple>

         */

//after refactor and sort firsttfiles then names