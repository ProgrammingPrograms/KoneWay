package com.example.farmersinternational.dataLayer.buildDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.farmersinternational.Extras.dateConverter
import com.example.farmersinternational.Extras.listConverter
import com.example.farmersinternational.dataLayer.dao.FarmerDao
import com.example.farmersinternational.dataLayer.dao.OrderDao
import com.example.farmersinternational.dataLayer.dao.ProductDao
import com.example.farmersinternational.dataLayer.dao.UserDao
import com.example.farmersinternational.dataLayer.RoomEntity.EntityFarmer
import com.example.farmersinternational.dataLayer.RoomEntity.EntityOrder
import com.example.farmersinternational.dataLayer.RoomEntity.EntityProduct
import com.example.farmersinternational.dataLayer.RoomEntity.EntityUser

@Database
    (entities = [EntityFarmer::class, EntityOrder::class, EntityProduct::class,
        EntityUser::class], version = 1)//or 7

@TypeConverters(dateConverter::class, listConverter::class)
abstract class StructureOfLocalDatabase: RoomDatabase(){

abstract fun getFarmerDao(): FarmerDao
    abstract fun getOrderDao(): OrderDao
    abstract fun getProductDao(): ProductDao
    abstract fun getUserDao(): UserDao

    companion object {
        private fun buildDatabase(context: Context): StructureOfLocalDatabase {
            return Room.databaseBuilder(context, StructureOfLocalDatabase::class.java,
                "LocalDatabase").build()//physical databasee
            }

        @Volatile
        private var INSTANCE : StructureOfLocalDatabase? = null

        fun getDatabase(context: Context): StructureOfLocalDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                INSTANCE = buildDatabase(context)
                    }
            }
            return INSTANCE!!
        }
    }
    // multiple bdoies mean under the conditions, so. learn like that
    //read code build mental representations, and then whilest loking,
    //at code see which mental representations you understand the bset,
    //by looking at other code and wun


}


//contaact events = event,,
// so hes handling the event layer outside of the ui
//so ui can just call that event