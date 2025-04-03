package com.example.farmersinternational.Core.Repository

import com.example.farmersinternational.Core.Database.Dao.ProductDao
import javax.inject.Inject
//specifies weather or not its offline or online
class OfflineFirstProductRepository @Inject constructor(private val productDao: ProductDao):ProductRepository {

}