package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun HomeScreen(
    modifier: Modifier
){
    Column(modifier = modifier) {
        HomeTopBar()
        StorySection()
        FeedsSection()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    InstagramUITheme {
        HomeScreen(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clipToBounds()
        )
    }
}