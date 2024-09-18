package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.core.type.TypeAmount.Companion.getTypeAmountById
import com.example.pocketwallet.domain.model.GroupList
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GroupedLazyColumn(
    group: List<GroupList>, modifier: Modifier, onItemSelected: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 125.dp)
            .padding(horizontal = 6.dp)
    ) {
        LazyColumn(modifier) {
            group.forEach { group ->
                stickyHeader {
                    Text(
                        text = group.date,
                        color = Primary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .fillMaxWidth()
                            .background(Black)
                            .padding(12.dp)
                    )
                }
                items(group.items) { item ->
                    if (item.type > 0) {
                        val typeAmount = getTypeAmountById(item.type)!!
                        val title = item.note.ifEmpty { stringResource(id = typeAmount.title) }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp)
                                .padding(vertical = 6.dp)
                                .clickable {
                                    onItemSelected(item.id)
                                }, verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = typeAmount.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(end = 24.dp)
                                    .size(32.dp)
                            )
                            Text(
                                text = title,
                                color = White,
                                fontSize = 15.sp,
                                modifier = modifier
                                    .background(Black)
                                    .weight(1f)
                            )
                            Text(
                                text = "${item.amount} €",
                                color = White,
                                fontSize = 15.sp,
                                modifier = modifier.background(Black)
                            )
                        }
                    }
                }
            }
        }
    }

}