package com.example.pocketwallet.motherobject

import com.example.pocketwallet.data.room.entities.WalletEntity
import com.example.pocketwallet.domain.model.WalletModel
import java.util.Date

object PocketWalletMotherObject {
    const val ANY_ID = 1

    val anyWalletModel = WalletModel(1, Date(), 1, 1000f, "noteTest")
    val anyWalletEntity = WalletEntity(1, Date(), 1, 1000f, "noteTest")

    val anyListWalletModel = listOf(anyWalletModel, anyWalletModel)
    val anyListWalletEntity = listOf(anyWalletEntity, anyWalletEntity)
}