package com.example.farmersinternational.DataLayer.DataModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.farmersinternational.DataLayer.DataSource.farmerDataSource
import com.example.farmersinternational.DataLayer.DataSource.farmerPostDataSource
import com.example.farmersinternational.DataLayer.DataSource.notificationsDataSource
import com.example.farmersinternational.DataLayer.DataSource.userCartDataSource

@Database(entities = [farmerPostModel::class, notificationsModel::class,userCartModel::class,
        farmerModel::class], version = 6)
abstract class appDatabase: RoomDatabase(){

abstract fun getFarmerPostDataSource(): farmerPostDataSource
    abstract fun getNotificationDataSource(): notificationsDataSource
    abstract fun getUserCartDataSource(): userCartDataSource
    abstract fun getFarmerDataSource(): farmerDataSource

  //can do a practice understanding this better

    companion object {
        private fun buildDatabase(context: Context): appDatabase {
            return Room.databaseBuilder(context, appDatabase::class.java,
                "Databases").build()
            }

        @Volatile
        private var INSTANCE : appDatabase? = null

        fun getDatabase(context: Context): appDatabase {
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