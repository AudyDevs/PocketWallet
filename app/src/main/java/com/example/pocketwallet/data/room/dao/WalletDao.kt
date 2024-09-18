package com.example.pocketwallet.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pocketwallet.data.room.entities.WalletEntity

@Dao
interface WalletDao {

    @Query("SELECT * FROM wallet ORDER BY id ASC")
    suspend fun getWallets(): List<WalletEntity>

    @Query("SELECT * FROM wallet WHERE id = :id")
    suspend fun getWalletID(id: Int): WalletEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallet(wallet: WalletEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWallet(wallet: WalletEntity)

    @Query("DELETE FROM wallet WHERE id = :id")
    suspend fun deleteWallet(id: Int)
}