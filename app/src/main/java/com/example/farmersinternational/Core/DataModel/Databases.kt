package com.example.farmersinternational.Core.DataModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.farmersinternational.Core.Database.Dao.FarmerDao
import com.example.farmersinternational.Core.Database.Dao.OrderDao
import com.example.farmersinternational.Core.Database.Dao.ProductDao
import com.example.farmersinternational.Core.Database.Dao.UserDao
import com.example.farmersinternational.Core.Database.model.EntityFarmer
import com.example.farmersinternational.Core.Database.model.EntityOrder
import com.example.farmersinternational.Core.Database.model.EntityProduct
import com.example.farmersinternational.Core.Database.model.EntityUser

@Database
    (entities = [EntityFarmer::class, EntityOrder::class, EntityProduct::class,
        EntityUser::class], version = 1)//or 7
abstract class StructureOfLocalDatabase: RoomDatabase(){//room database file, which defines the structure etc

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