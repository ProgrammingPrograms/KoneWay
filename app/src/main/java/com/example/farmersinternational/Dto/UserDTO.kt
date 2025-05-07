package com.example.farmersinternational.Dto

import androidx.room.ColumnInfo

data class UserDTO(
    @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "profilePhoto") val profilePhoto: String

)
