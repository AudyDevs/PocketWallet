package com.example.pocketwallet.domain

import com.example.pocketwallet.domain.model.WalletModel

interface WalletRepository {
    suspend fun getWallets(): List<WalletModel>

    suspend fun getWalletId(id: Int): WalletModel?

    suspend fun insertWallet(wallet: WalletModel)

    suspend fun updateWallet(wallet: WalletModel)

    suspend fun deleteWallet(id: Int)
}