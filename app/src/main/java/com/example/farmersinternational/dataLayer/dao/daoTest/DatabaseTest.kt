package com.example.farmersinternational.dataLayer.dao.daoTest

import android.content.Context
import androidx.room.Room
import com.example.farmersinternational.dataLayer.buildDatabase.StructureOfLocalDatabase
import com.example.farmersinternational.dataLayer.dao.FarmerDao
import com.example.farmersinternational.dataLayer.dao.OrderDao
import com.example.farmersinternational.dataLayer.dao.ProductDao
import com.example.farmersinternational.dataLayer.dao.UserDao
import org.junit.Before
import androidx.test.core.app.ApplicationProvider
import com.example.farmersinternational.dataLayer.domainModel.Order
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test


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
    userDao = temporaryDatabase.getUserDao()
    productDao = temporaryDatabase.getProductDao()

    @After //do after each test
    fun destroyTemporaryDatabase() = temporaryDatabase.close()
}
    @Test
    fun getOrderSummary(): Unit = runBlocking{
        val order = Order(
            orderId = 1,
            userId = 2,
            productId = 3,
            price = 3.39,
            date = 0719,
        )
orderDao.getOrderSummary()
    }

}