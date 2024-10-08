package com.example.pocketwallet.domain.model

import java.util.Date

data class WalletModel(
    val id: Int,
    var date: Date?,
    val type: Int,
    val amount: Float,
    val note: String
)