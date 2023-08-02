package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Reels

@Composable
fun ReelsOverlay(modifier: Modifier, reels: Reels){
    Row(modifier = modifier.padding(bottom = 32.dp)) {
        ReelsDetailOverlay(
            reels = reels,
            modifier = Modifier
                .weight(9f)
                .align(Alignment.Bottom)
        )
        ReelsButtonOverlay(
            reels = reels,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.Bottom)
        )
    }
}