package com.example.pocketwallet.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketwallet.core.DispatcherProvider
import com.example.pocketwallet.domain.model.GroupList
import com.example.pocketwallet.domain.model.ItemList
import com.example.pocketwallet.domain.model.WalletModel
import com.example.pocketwallet.domain.usecase.GetWalletsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getWalletsUseCase: GetWalletsUseCase
) : ViewModel() {

    private val _wallets = MutableStateFlow<List<WalletModel>>(emptyList())
    val wallet: StateFlow<List<WalletModel>> = _wallets

    private val _groups = MutableStateFlow<List<GroupList>>(emptyList())
    val groups: StateFlow<List<GroupList>> = _groups

    fun getWallets() {
        viewModelScope.launch {
            _wallets.value = withContext(dispatcherProvider.io) {
                getWalletsUseCase.invoke()
            }
        }
    }

    fun getGroups(initialDateFilter: Date?, finalDateFilter: Date?) {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault())
        val formatWithOutTime = SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000Z")
        _wallets.value.forEach {
            it.date = format.parse(formatWithOutTime.format(it.date?.time ?: ""))
        }

        val walletsFiltered = if ((initialDateFilter != null) and (finalDateFilter != null)) {
             _wallets.value.filter {
                it.date!!.after(initialDateFilter) and it.date!!.before(
                    finalDateFilter
                )
            }
        }else{
            _wallets.value
        }

        var formatSimpleDate = SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale("es", "ES"))
        _groups.value = walletsFiltered
            .filter { it.date != null }
            .groupBy { it.date }
            .map { (date, items) ->
                GroupList(
                    date = formatSimpleDate.format(date?.time ?: ""),
                    items = items.map { wallet ->
                        ItemList(
                            id = wallet.id,
                            type = wallet.type,
                            amount = wallet.amount,
                            note = wallet.note
                        )
                    }
                )
            }
        formatSimpleDate = SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale("es", "ES"))
    }
}