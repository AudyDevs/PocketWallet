package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import javax.inject.Inject

class GetWalletsUseCase @Inject constructor(private val repository: WalletRepository) {
    suspend operator fun invoke() = repository.getWallets()
}