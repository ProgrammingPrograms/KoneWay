package com.example.farmersinternational.Extras

import androidx.room.TypeConverter
import kotlinx.datetime.Instant


class dateConverter {

    @TypeConverter
    fun instantToRoom(time: Instant):Long {
        return time.toEpochMilliseconds()
    }

    @TypeConverter
    fun roomToInstant(time:Long):Instant  {
        return Instant.fromEpochMilliseconds(time)
    }
}