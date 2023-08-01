package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
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
        ButtonOverlay(reels = reels, modifier = modifier)
    }
}

@Composable
fun ButtonOverlay(reels: Reels, modifier: Modifier) {
    ReelsTopBar()
}

@Composable
fun ReelsTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(text = "Reels", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
        }
        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
    }
}

@Composable
fun YoutubeScreen(
    videoId: String,
    modifier: Modifier,
) {
    val ctx = LocalContext.current
    AndroidView(
        modifier = modifier,
        factory = {
            var view = YouTubePlayerView(it)
            val fragment = view.addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.loadVideo(videoId, 0f)
                    }
                }
            )
            view
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ReelsPreview() {
    InstagramUITheme {
        ReelsScreen(modifier = Modifier.fillMaxSize())
    }
}