package com.example.farmersinternational.Extras

import androidx.room.TypeConverter
import kotlinx.datetime.Instant


class dateConverter {

    @TypeConverter
    fun stringToTime(time: Instant):Long {
        return time.toEpochMilliseconds()
    }

    @TypeConverter
    fun timeToString(time:Long):Instant  {
        return Instant.fromEpochMilliseconds(time)
    }
}