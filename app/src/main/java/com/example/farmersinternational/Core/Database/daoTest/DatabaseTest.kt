package com.example.farmersinternational.Core.Database.daoTest

import android.content.Context
import androidx.room.Room
import com.example.farmersinternational.Core.DataModel.StructureOfLocalDatabase
import com.example.farmersinternational.Core.Database.Dao.FarmerDao
import com.example.farmersinternational.Core.Database.Dao.OrderDao
import com.example.farmersinternational.Core.Database.Dao.ProductDao
import com.example.farmersinternational.Core.Database.Dao.UserDao
import org.junit.Before
import androidx.test.core.app.ApplicationProvider
import org.junit.After


internal abstract class DatabaseTest {
    private lateinit var temporaryDatabase: StructureOfLocalDatabase
    protected lateinit var  farmerDao: FarmerDao
    protected lateinit var  orderDao: OrderDao
    protected lateinit var  userDao: UserDao
    protected lateinit var  productDao: ProductDao


@Before //run before each test
fun setup() { //create tempdatabase for testing
    temporaryDatabase = run {
        val context = ApplicationProvider.getApplicationContext<Context>()
        Room.inMemoryDatabaseBuilder(
            context,
            StructureOfLocalDatabase::class.java
        ).build()

    }
    farmerDao = temporaryDatabase.getFarmerDao()//get news dao from dbcuz u have to do th
    orderDao = temporaryDatabase.getOrderDao()//get topic dao from database

    @After
    fun destroyTemporaryDatabase() = temporaryDatabase.close()
}

}