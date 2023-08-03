package com.reift.instagram_ui.screen.home.screen.story

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Story
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(index: Int, modifier: Modifier) {
    val pagerState = rememberPagerState(index)
    HorizontalPager(modifier = modifier,
        pageCount = Story.listStory.size,
        state = pagerState) { page ->
        val story = Story.listStory[page]
        val transition = updateTransition(targetState = pagerState.currentPage, label = "")

        val tranformation by transition.animateFloat(label = "") { targetPage ->
            val pageOffset = (targetPage - page + pagerState.currentPageOffsetFraction).coerceIn(-1f, 1f)
            if (pageOffset < 0) {
                lerp(0f, 90f, pageOffset.absoluteValue)
            } else {
                lerp(0f, -90f, pageOffset.absoluteValue)
            }
        }
        Box(modifier = modifier.graphicsLayer {
            rotationY = tranformation
        }) {
            Image(
                painter = rememberAsyncImagePainter(model = story.imageUrl),
                contentDescription = null,
                modifier = modifier
                    .background(Color.Black)
            )
            Column(modifier = modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
                StoryHeader(story)
                StoryFooter(story)
            }
        }
    }
}

@Composable
fun StoryFooter(story: Story) {

}

@Preview(showBackground = true)
@Composable
fun StoryScreenPreview() {
    InstagramUITheme {
        StoryScreen(modifier = Modifier.fillMaxSize(), index = 0)
    }
}