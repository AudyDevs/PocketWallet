package com.example.pocketwallet.domain.model

data class GroupList(
    val date: String,
    val items: List<ItemList>
)

data class ItemList(
    val id: Int,
    val type: Int,
    val amount: Float,
    val note: String
)