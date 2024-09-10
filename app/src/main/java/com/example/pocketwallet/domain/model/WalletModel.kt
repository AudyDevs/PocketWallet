package com.example.pocketwallet.domain.model

import java.util.Date

data class WalletModel(
    val id: Int,
    val date: Date?,
    val type: String,
    val amount: Float,
    val note: String
)