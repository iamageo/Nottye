package com.iamageo.nottye.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.iamageo.domain.model.Nottye
import com.iamageo.nottye.ui.theme.paleBlack
import com.iamageo.nottye.ui.theme.paleWhite

@Composable
fun NottyeItem(
    nottye: Nottye,
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
                text = nottye.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nottye.content,
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
                contentDescription = "Delete nottye",
                tint = MaterialTheme.colors.onSurface
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(2.dp)
                .background(
                    color = Color(
                        ColorUtils.blendARGB(nottye.color, 0x000000, 0.2f)
                    ),
                ),
        ) {}
    }
}
