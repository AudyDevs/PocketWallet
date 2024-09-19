package com.example.pocketwallet.presentation.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import com.example.pocketwallet.presentation.ui.theme.LightBlack
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.White
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DialogDatePicker(
    dateDialogState: MaterialDialogState,
    onSelectedDate: (selectedDate: Date) -> Unit
) {
    MaterialDialog(
        dialogState = dateDialogState,
        backgroundColor = LightBlack,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        ),
        buttons = {
            positiveButton(text = "OK")
            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            colors = DatePickerDefaults.colors(
                headerBackgroundColor = LightBlack,
                headerTextColor = Primary,
                calendarHeaderTextColor = Primary,
                dateActiveBackgroundColor = Primary,
                dateInactiveBackgroundColor = LightBlack,
                dateActiveTextColor = White,
                dateInactiveTextColor = White
            )
        ) { localDate ->
            val localDateTime = localDate.atStartOfDay()
                .plusHours(LocalDateTime.now().hour.toLong())
                .plusMinutes(LocalDateTime.now().minute.toLong())
                .plusSeconds(LocalDateTime.now().second.toLong())
            val dateSelected = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
            onSelectedDate(dateSelected)
        }
    }
}
