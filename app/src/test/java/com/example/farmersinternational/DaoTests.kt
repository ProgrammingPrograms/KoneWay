package com.example.farmersinternational

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.farmersinternational.dataLayer.LocalModel.EntityUser
import com.example.farmersinternational.dataLayer.buildDatabase.StructureOfLocalDatabase
import com.example.farmersinternational.dataLayer.dao.UserDao
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.io.IOException
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleEntityQueriesTest {

    private lateinit var userDao: UserDao
    private lateinit var db: StructureOfLocalDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, StructureOfLocalDatabase::class.java).build()
        userDao = db.getUserDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
     fun writeUserAndReadInList() = runBlocking{
        val user =  EntityUser(
            userId = 1,
            fullName = "john",
            profilePhoto = "",
            userOnFootOnBikeOnCar = 2,
            notification = 1
        )
        userDao.insertOrIgnoreUser(user)
        val getem = userDao.getUserWhoBuying(1).first()//flow so you have to collect
        assertEquals(user, getem)
    }
}