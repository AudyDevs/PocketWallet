package com.example.pocketwallet.core

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.pocketwallet.core.type.TabSelection
import com.example.pocketwallet.core.type.TypeFilter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Dates {
    @RequiresApi(Build.VERSION_CODES.O)
    fun minusMonth(minus: Long): Pair<String, String> {
        val minusMonth = LocalDate.now().minusMonths(minus)
        val month = minusMonth
            .format(
                DateTimeFormatter.ofPattern("MMMM", Locale("es", "ES"))
            ).replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
            }
        val year = minusMonth.format(DateTimeFormatter.ofPattern("yyyy"))
        return Pair(month, year)
    }

    fun calculationDateFilter(tabSelection: TabSelection): Pair<Date?, Date?> {
        val calendar = Calendar.getInstance()
        val initialDateFilter: Date?
        val finalDateFilter: Date?
        when (tabSelection.typeFilter) {
            TypeFilter.AllTime -> {
                initialDateFilter = null
                finalDateFilter = null
            }

            TypeFilter.ThisYear -> {
                calendar.time = Date()
                calendar.set(Calendar.DAY_OF_YEAR, 1)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                initialDateFilter = calendar.time
                calendar.add(Calendar.YEAR, 1)
                calendar.add(Calendar.SECOND, -1)
                finalDateFilter = calendar.time
            }

            TypeFilter.ThisMonth -> {
                calendar.time = Date()
                calendar.set(Calendar.DAY_OF_MONTH, 1)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                initialDateFilter = calendar.time
                calendar.add(Calendar.MONTH, 1)
                calendar.add(Calendar.SECOND, -1)
                finalDateFilter = calendar.time
            }

            TypeFilter.Month -> {
                calendar.time = Date()
                calendar.set(Calendar.DAY_OF_MONTH, 1)
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                calendar.add(Calendar.MONTH, (-tabSelection.minusMonth).toInt())
                initialDateFilter = calendar.time
                calendar.add(Calendar.MONTH, 1)
                calendar.add(Calendar.SECOND, -1)
                finalDateFilter = calendar.time
            }
        }
        return Pair(initialDateFilter, finalDateFilter)
    }
}