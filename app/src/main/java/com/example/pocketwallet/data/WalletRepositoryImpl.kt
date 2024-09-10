package com.example.pocketwallet.data

import com.example.pocketwallet.core.mappers.toDomain
import com.example.pocketwallet.core.mappers.toRoom
import com.example.pocketwallet.data.room.dao.WalletDao
import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.domain.model.WalletModel
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
    private val walletDao: WalletDao
) : WalletRepository {

    override suspend fun getWallets(): List<WalletModel> {
        val response = walletDao.getWallets()
        return response.map { it.toDomain() }
    }

    override suspend fun getWalletId(id: Int): WalletModel {
        val response = walletDao.getWalletID(id)
        return response.toDomain()
    }

    override suspend fun insertWallet(wallet: WalletModel) {
        val response = wallet.toRoom()
        walletDao.insertWallet(response)
    }

    override suspend fun updateWallet(wallet: WalletModel) {
        val response = wallet.toRoom()
        walletDao.updateWallet(response)
    }

    override suspend fun deleteWallet(wallet: WalletModel) {
        val response = wallet.toRoom()
        walletDao.deleteWallet(response)
    }
}