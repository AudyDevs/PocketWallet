package com.example.pocketwallet.core.mappers

import com.example.pocketwallet.data.room.entities.WalletEntity
import com.example.pocketwallet.domain.model.WalletModel

fun WalletEntity.toDomain() = WalletModel(
    id = id,
    date = date,
    type = type,
    amount = amount,
    note = note
)

fun WalletModel.toRoom() = WalletEntity(
    id = id,
    date = date,
    type = type,
    amount = amount,
    note = note
)