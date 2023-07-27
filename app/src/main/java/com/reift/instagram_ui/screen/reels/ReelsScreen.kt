package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.reift.instagram_ui.screen.home.HomeScreen
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun ReelsScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Text(text = "Reels", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReelsPreview() {
    InstagramUITheme {
        ReelsScreen(modifier = Modifier.fillMaxSize())
    }
}