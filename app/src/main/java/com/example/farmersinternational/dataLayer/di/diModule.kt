package com.example.farmersinternational.dataLayer.di

import com.example.farmersinternational.dataLayer.dao.FarmerDao
import com.example.farmersinternational.dataLayer.dao.OrderDao
import com.example.farmersinternational.dataLayer.dao.ProductDao
import com.example.farmersinternational.dataLayer.dao.UserDao
import com.example.farmersinternational.dataLayer.buildDatabase.StructureOfLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
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
}