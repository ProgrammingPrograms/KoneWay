package com.example.farmersinternational.Extras

import androidx.room.TypeConverter

class listConverter{

    @TypeConverter
    fun listToString(data: List<Long?>?):String{
        return data?.joinToString( ",") ?: ""
    }
    @TypeConverter
    fun StringToList(data:String):List<Long>{
        return data.split(",").mapNotNull { it.toLongOrNull() }
    }
}