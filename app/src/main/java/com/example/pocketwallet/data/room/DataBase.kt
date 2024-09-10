package com.example.pocketwallet.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pocketwallet.data.room.dao.WalletDao
import com.example.pocketwallet.data.room.entities.WalletEntity

@Database(
    entities = [WalletEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract fun loadWalletDao(): WalletDao
}