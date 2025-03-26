package com.example.farmersinternational.DataLayer.DataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.farmersinternational.DataLayer.ModelEntity.EntityFarmer
import com.example.farmersinternational.DataLayer.ModelEntity.EntityProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface farmerDao {

    @Query("SELECT * FROM ENTITYFARMER WHERE farmerId = :farmerId")
    fun getFarmerById(farmerId: Long): Flow<EntityFarmer>

    @Query("SELECT * FROM ENTITYFARMER WHERE farmerId = (:farmerIds)")
    fun getFarmersByIds(farmerIds: Set<Long>): Flow<List<EntityFarmer>>

    @Query("SELECT ENTITYFARMER.*,ENTITYPRODUCT.isGMO," +
            "ENTITYPRODUCT.isOrganic, ENTITYPRODUCT.imageUrl FROM ENTITYFARMER INNER JOIN ENTITYPRODUCT" +
            " ON ENTITYFARMER.farmerId = ENTITYPRODUCT.farmerId" +
            " WHERE ENTITYFARMER.farmerId IN (:farmerIds) ORDER BY ENTITYPRODUCT.IsGmo DESC," +
            "ENTITYPRODUCT.IsOrganic DESC ")
    fun getFarmersSortedByGmo(farmerIds: Set<Long>): Flow<List<EntityFarmer>>

    @Query("SELECT ENTITYFARMER.*,EntityProduct.name,ENTITYPRODUCT.imageUrl, EntityProduct.isOrganic," +
            " EntityProduct.isGmo, EntityProduct.isOrganic  FROM ENTITYFARMER INNER JOIN ENTITYPRODUCT " +
            "ON ENTITYFARMER.farmerId = EntityProduct.farmerId WHERE ENTITYFARMER.farmerId IN (:farmerIds) ")
    fun getFarmersWithProducts(farmerIds: Set<Long>) : Map<List<EntityFarmer>, EntityProduct>git
    //farmer, with farmers information and the product, main screen

    // + for screen when person show grapes and stuff like that
    // farmer page showing their product/ product dao

    // look up all those seperation of concers that ali sent and which one matches what i need for this

    //

    //do in seperate dao
//read code
//all the product information and it just so happens to show the producct
    //no i want that aswell seperately
            // going to have fruits and vegetables. interface, or sealed interface
            //How to sort products being displayed
            // fruits or veggies
            //
    //want to show list of farmers based on theirs selling

    //want to show list of farmers based on their selling non-gmo xyz
//fix thought processes in this

}