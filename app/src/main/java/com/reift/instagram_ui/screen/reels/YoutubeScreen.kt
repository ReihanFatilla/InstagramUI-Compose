package com.reift.instagram_ui.screen.reels

import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBarListener
import com.reift.instagram_ui.model.Reels

@Composable
fun YoutubeScreen(
    reels: Reels,
    modifier: Modifier,
) {
    Box(modifier = modifier){
        AndroidView(
            modifier = modifier,
            factory = {
                YouTubePlayerView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            youTubePlayer.loadVideo(reels.youtubeUrl, 0f)
                        }
                    })

                }
            }
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(72.dp).background(Color.Black).align(Alignment.TopCenter))
        Spacer(modifier = Modifier.fillMaxWidth().height(64.dp).background(Color.Black).align(Alignment.BottomCenter))
    }

}