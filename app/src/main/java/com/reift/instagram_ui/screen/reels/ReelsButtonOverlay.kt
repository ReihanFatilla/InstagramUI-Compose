package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reift.instagram_ui.model.Reels

@Composable
fun ReelsButtonOverlay(reels: Reels, modifier: Modifier) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ButtonColumn(text = reels.likedBy.size.toString(), icon = Icons.Outlined.FavoriteBorder)
        ButtonColumn(text = reels.listComment.size.toString(), icon = Icons.Outlined.MailOutline)
        ButtonColumn(text = (10..100).random().toString(), icon = Icons.Outlined.Send)
    }
}

@Composable
private fun ButtonColumn(text: String, icon: ImageVector) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
        Text(text = text, fontSize = 12.sp, color = Color.White)
    }
}