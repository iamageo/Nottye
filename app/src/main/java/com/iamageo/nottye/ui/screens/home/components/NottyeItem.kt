package com.iamageo.nottye.ui.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamageo.domain.model.Nottye
import com.iamageo.nottye.Screens
import com.iamageo.nottye.ui.screens.home.NottyeEvents
import com.iamageo.nottye.ui.theme.RedA100
import com.iamageo.nottye.ui.theme.paleBlack
import com.iamageo.nottye.ui.theme.paleWhite
import kotlinx.coroutines.launch

@Composable
fun NottyeItem(
    note: Nottye,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier.background(
            color = if (isSystemInDarkTheme()) paleWhite else paleBlack,
            //shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete note",
                tint = MaterialTheme.colors.onSurface
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(2.dp)
                .background(
                    color = RedA100,
                ),
        ){}
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun NottyeCard() {
    NottyeItem(
        note = Nottye(
            title = "Teste",
            content = "descrição",
            timestamp = 1234567,
            color = Color.RED,
        ),
        modifier = Modifier.height(200.dp),
        onDeleteClick = {}
    )
}