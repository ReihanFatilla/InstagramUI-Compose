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
}

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


@Composable
fun ReelsDetailOverlay(reels: Reels, modifier: Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
    ) {
        UserRow(reels)
        Text(text = reels.caption, fontSize = 12.sp, color = Color.White)
        LikedByRow(modifier = Modifier , likedBy = reels.likedBy)
    }
}

@Composable
private fun UserRow(reels: Reels) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = reels.user.profileUrl),
            contentDescription = null,
            modifier = Modifier
                .width(25.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = reels.user.username,
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedButton(
            onClick = { },
            modifier = Modifier.height(28.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.White),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        ) {
            Text(text = "Follow", fontSize = 10.sp, color = Color.White)
        }
    }
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
            Text(text = "Reels",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White)
            Icon(imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.White)
        }
        Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.White)
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

@Composable
fun LikedByRow(modifier: Modifier, likedBy: List<User>) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(modifier = Modifier.width((20 + (10 * (likedBy.size - 1))).dp)) {
            likedBy.forEachIndexed { index, story ->
                Image(
                    painter = rememberAsyncImagePainter(model = story.profileUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = (10 * (index)).dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                        .background(Color.White)
                )
            }
        }
        Text(text = "Liked by",
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.White)
        Text(text = likedBy.first().username,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White)
        Text(text = "and", fontWeight = FontWeight.Normal, fontSize = 12.sp, color = Color.White)
        Text(text = "others", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
    }
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