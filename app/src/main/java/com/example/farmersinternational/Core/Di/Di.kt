package com.example.farmersinternational.Core.Di

import com.example.farmersinternational.Core.Database.Dao.FarmerDao
import com.example.farmersinternational.Core.Database.Dao.OrderDao
import com.example.farmersinternational.Core.Database.Dao.ProductDao
import com.example.farmersinternational.Core.Database.Dao.UserDao
import com.example.farmersinternational.Core.DataModel.StructureOfLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//dependancy injections for the daos to be accessed app wide
@Module// helper -  HEY dagger heres how you give me object
@InstallIn(SingletonComponent::class)//object available in whole app through a simngleComponent
internal object DaoModule {
    @Provides // how to provide the daos
    fun providesFarmerDao(
        database: StructureOfLocalDatabase
    ): FarmerDao = database.getFarmerDao()

    @Provides
    fun providesOrderDao(
        database: StructureOfLocalDatabase
    ): OrderDao = database.getOrderDao()

    @Provides
    fun providesProductDao(
        database: StructureOfLocalDatabase
    ): ProductDao = database.getProductDao()

    @Provides
    fun providesUserDao(
        database: StructureOfLocalDatabase
    ): UserDao = database.getUserDao()
}// allows appwide access to dependancies as singleton