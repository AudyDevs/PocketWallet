package com.example.pocketwallet.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketwallet.core.DispatcherProvider
import com.example.pocketwallet.domain.model.WalletModel
import com.example.pocketwallet.domain.usecase.DeleteWalletUseCase
import com.example.pocketwallet.domain.usecase.GetWalletIdUseCase
import com.example.pocketwallet.domain.usecase.InsertWalletUseCase
import com.example.pocketwallet.domain.usecase.UpdateWalletUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getWalletIdUseCase: GetWalletIdUseCase,
    private val insertWalletUseCase: InsertWalletUseCase,
    private val updateWalletUseCase: UpdateWalletUseCase,
    private val deleteWalletUseCase: DeleteWalletUseCase
) : ViewModel() {

    private val _wallet = MutableStateFlow<WalletModel?>(null)
    val wallet: StateFlow<WalletModel?> = _wallet

    fun getWalletId(id: Int) {
        viewModelScope.launch {
            _wallet.value = withContext(dispatcherProvider.io) {
                getWalletIdUseCase.invoke(id = id)
            }
        }
    }

    fun insertWallet(wallet: WalletModel) {
        viewModelScope.launch {
            withContext(dispatcherProvider.io) {
                insertWalletUseCase.invoke(wallet = wallet)
            }
        }
    }

    fun updateWallet(wallet: WalletModel) {
        viewModelScope.launch {
            withContext(dispatcherProvider.io) {
                updateWalletUseCase.invoke(wallet = wallet)
            }
        }
    }

    fun deleteWallet(id: Int) {
        viewModelScope.launch {
            withContext(dispatcherProvider.io) {
                deleteWalletUseCase.invoke(id = id)
            }
        }
    }

    fun nextDay(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        return calendar.time
    }

    fun previewDay(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        return calendar.time
    }
}