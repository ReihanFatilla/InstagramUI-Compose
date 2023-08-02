package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.reift.instagram_ui.model.Reels
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsScreen(modifier: Modifier) {
    Box(modifier = modifier) {
        VerticalPager(pageCount = 2, modifier = modifier) { index ->
            ReelsSection(reels = Reels.listReels[index], modifier = modifier)
        }
        ReelsTopBar()
    }
}

@Composable
fun ReelsSection(reels: Reels, modifier: Modifier) {
    Box(modifier = modifier) {
        YoutubeScreen(videoId = reels.youtubeUrl, modifier = modifier)
        Surface(color = Color.Transparent) {
            ReelsOverlay(reels = reels)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReelsPreview() {
    InstagramUITheme {
        ReelsScreen(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black))

    }
}