package com.example.pocketwallet.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pocketwallet.R
import com.example.pocketwallet.core.type.TypeAmount
import com.example.pocketwallet.domain.model.WalletModel
import com.example.pocketwallet.presentation.composable.BackButton
import com.example.pocketwallet.presentation.composable.ButtonDetail
import com.example.pocketwallet.presentation.composable.CustomEditText
import com.example.pocketwallet.presentation.composable.DeleteButton
import com.example.pocketwallet.presentation.composable.GridTypes
import com.example.pocketwallet.presentation.composable.RowDatePicker
import com.example.pocketwallet.presentation.composable.TextTitle
import com.example.pocketwallet.presentation.dialog.DialogDatePicker
import com.example.pocketwallet.presentation.dialog.DialogDelete
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.White
import com.example.pocketwallet.presentation.viewmodel.DetailViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AmountScreen(
    itemSelected: Int,
    navigateToBack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.getWalletId(id = itemSelected)
    val wallet by viewModel.wallet.collectAsState()

    var amount by remember { mutableStateOf("") }
    var date by remember { mutableStateOf(Date()) }
    var note by remember { mutableStateOf("") }
    var type by remember { mutableIntStateOf(1) }
    var showDialogDatePicker by remember { mutableStateOf(false) }
    var showDialogDelete by remember { mutableStateOf(false) }
    var firstLoadField by remember { mutableStateOf(false) }

    val format = SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale("es", "ES"))
    val formatDate = format.format(date.time).ifEmpty {
        stringResource(id = R.string.text_date)
    }

    val title =
        if (itemSelected > 0) stringResource(id = R.string.title_update) else stringResource(id = R.string.title_save)

    if (showDialogDatePicker) {
        DialogDatePicker {
            date = it
            showDialogDatePicker = false
        }
    }

    if (showDialogDelete) {
        DialogDelete(
            showDialog = showDialogDelete,
            onConfirm = {
                viewModel.deleteWallet(itemSelected)
                navigateToBack()
            },
            onDismiss = { showDialogDelete = false }
        )
    }

    if (wallet != null) {
        if (!firstLoadField) {
            amount = wallet?.amount.toString()
            date = wallet?.date!!
            note = wallet?.note.toString()
            type = TypeAmount.getTypeAmountById(wallet?.type!!)!!.id
            firstLoadField = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(24.dp, 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitle(title, 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        GridTypes(
            type = type,
            onTypeSelected = { type = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomEditText(
            value = amount,
            textLabel = R.string.field_amount,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            showTrailingIcon = true,
            onValueChange = {
                amount = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomEditText(
            value = note,
            textLabel = R.string.field_note,
            keyboardOptions = KeyboardOptions.Default,
            showTrailingIcon = false,
            onValueChange = {
                note = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        RowDatePicker(
            formatDate = formatDate,
            onPreviewDay = { date = viewModel.previewDay(date) },
            onDatePickerSelected = { showDialogDatePicker = true },
            onNextDay = { date = viewModel.nextDay(date) }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonDetail(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth(),
            text = stringResource(id = R.string.text_button_save),
            buttonColor = Primary,
            textColor = White,
            onButtonClicked = {
                val walletModel = WalletModel(
                    id = itemSelected,
                    date = date,
                    type = type,
                    amount = amount.toFloat(),
                    note = note,
                )
                if (itemSelected > 0) {
                    viewModel.updateWallet(walletModel)
                    navigateToBack()
                } else {
                    viewModel.insertWallet(walletModel)
                    navigateToBack()
                }
            })
    }
    BackButton(
        onButtonClick = {
            navigateToBack()
        }
    )
    if (itemSelected > 0) {
        DeleteButton(
            onButtonClick = {
                showDialogDelete = true
            }
        )
    }
}