package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberAsyncImagePainter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.model.Reels
import com.reift.instagram_ui.model.User
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
        ReelsOverlay(modifier = modifier, reels = reels)
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
        Surface {
            ReelsScreen(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black))
        }
    }
}