package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable()
fun HomeTopBar() {
    Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Instagram", fontSize = 20.sp, color = Color.Black)
        Row {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Icon(imageVector = Icons.Outlined.Send, contentDescription = null)
        }
    }
}