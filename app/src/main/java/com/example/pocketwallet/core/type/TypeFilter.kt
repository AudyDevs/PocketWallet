package com.example.pocketwallet.core.type

sealed class TypeFilter {
    data object AllTime : TypeFilter()
    data object ThisYear : TypeFilter()
    data object ThisMonth : TypeFilter()
    data object Month : TypeFilter()
}