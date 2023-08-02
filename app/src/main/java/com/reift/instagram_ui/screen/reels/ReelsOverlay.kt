package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.model.Reels

@Composable
fun ReelsOverlay(reels: Reels) {
        Row(modifier = Modifier.background(Color.Transparent).fillMaxSize()) {
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