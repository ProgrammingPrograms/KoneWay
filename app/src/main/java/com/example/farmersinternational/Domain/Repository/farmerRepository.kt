package com.example.farmersinternational.Domain.Repository

import android.content.Context
import android.util.Log
import com.example.farmersinternational.DataLayer.DataModel.appDatabase
import com.example.farmersinternational.DataLayer.DataModel.farmerModel
import com.example.farmersinternational.supabase
import io.github.jan.supabase.storage.UploadStatus
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.storage.uploadAsFlow

class farmerRepository( private val AppDatabase: appDatabase, context: Context) {

    val farmerInfoData = appDatabase.getDatabase(context).getFarmerDataSource()
    val farmerPostData = appDatabase.getDatabase(context).getFarmerPostDataSource()


   suspend fun fetchFarmerInformation() = farmerInfoData.getById(farmerID = "")
    suspend fun fetchFarmerPostInformation() = farmerPostData.fetchFarmerPostData()

   suspend fun fetchFarmerPostSpecific() = farmerPostData.fetchFarmerPostSpecific()
   suspend fun fetchFarmerInfoSpecific() = farmerInfoData.fetchFarmerSpecificData()


     suspend fun upsertFarmerInformation(FarmerModel: farmerModel){ //user click button that saves information
       farmerInfoData.upsertFarmerInformation(FarmerModel)
    }

    suspend fun upsertFarmerPostInformation(FarmerPostModel: farmerPostModel){
        farmerPostData.upsertUserPostData(FarmerPostModel)

    }
    suspend fun saveUserImageUrl(userId:String, imageUrl:String) {
        val farmer = farmerInfoData.getById(farmerID = "")
        if(farmer !=null){
        }
    }

    suspend fun uploadFarmerImage() {
        val bucket = supabase.storage.from("farmers.information")
        bucket.uploadAsFlow("farmerImage${System.currentTimeMillis()}.png", byteArrayOf()).collect{
            when(it){
                is UploadStatus.Progress -> println("Progress: ${it.totalBytesSend.toFloat()/
                        it.contentLength * 100 }%")
                is UploadStatus.Success -> {
                    val imageUrl = bucket.publicUrl("farmerImage${System.currentTimeMillis()}.png")
                    Log.d("Upload", "Image Uploaded: $imageUrl")

                }
            }
        }
    }

}

