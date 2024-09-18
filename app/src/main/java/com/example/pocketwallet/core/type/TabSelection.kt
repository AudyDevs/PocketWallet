package com.example.pocketwallet.core.type

import com.example.pocketwallet.R

enum class TabSelection(
    val id: Int,
    val titleTab: Int,
    val minusMonth: Long,
    val typeFilter: TypeFilter
) {
    All(0, R.string.tab_all, 0, TypeFilter.AllTime),
    ThisYear(1, R.string.tab_this_year, 0, TypeFilter.ThisYear),
    ThisMonth(2, R.string.tab_this_month, 0, TypeFilter.ThisMonth),
    Minus1Month(3, R.string.tab_minus_month, 1, TypeFilter.Month),
    Minus2Month(4, R.string.tab_minus_month, 2, TypeFilter.Month),
    Minus3Month(5, R.string.tab_minus_month, 3, TypeFilter.Month),
    Minus4Month(6, R.string.tab_minus_month, 4, TypeFilter.Month),
    Minus5Month(7, R.string.tab_minus_month, 5, TypeFilter.Month),
    Minus6Month(8, R.string.tab_minus_month, 6, TypeFilter.Month),
    Minus7Month(9, R.string.tab_minus_month, 7, TypeFilter.Month),
    Minus8Month(10, R.string.tab_minus_month, 8, TypeFilter.Month),
    Minus9Month(11, R.string.tab_minus_month, 9, TypeFilter.Month),
    Minus10Month(12, R.string.tab_minus_month, 10, TypeFilter.Month),
    Minus11Month(13, R.string.tab_minus_month, 11, TypeFilter.Month),
    Minus12Month(14, R.string.tab_minus_month, 12, TypeFilter.Month);

    companion object {
        fun getTabSelectionById(id: Int): TabSelection? {
            return TabSelection.values().find { it.id == id }
        }
    }
}