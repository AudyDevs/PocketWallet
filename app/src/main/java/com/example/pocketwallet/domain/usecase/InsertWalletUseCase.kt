package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.domain.model.WalletModel
import javax.inject.Inject

class InsertWalletUseCase @Inject constructor(private val repository: WalletRepository) {
    suspend operator fun invoke(wallet: WalletModel) = repository.insertWallet(wallet)
}