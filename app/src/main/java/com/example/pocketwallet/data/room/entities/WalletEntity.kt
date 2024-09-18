package com.example.pocketwallet.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pocketwallet.data.room.converter.DateConverter
import java.util.Date

@Entity(tableName = "wallet")
@TypeConverters(DateConverter::class)
data class WalletEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "date") val date: Date? = null,
    @ColumnInfo(name = "type") val type: Int = 0,
    @ColumnInfo(name = "amount") val amount: Float = 0f,
    @ColumnInfo(name = "note") val note: String = ""
)