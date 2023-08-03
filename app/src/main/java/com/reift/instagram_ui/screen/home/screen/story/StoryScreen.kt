package com.reift.instagram_ui.screen.home.screen.story

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.reift.instagram_ui.model.Story
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(index: Int, modifier: Modifier) {
    val pagerState = rememberPagerState()
    HorizontalPager(modifier = modifier,
        pageCount = Story.listStory.size,
        state = pagerState) { page ->
        val transition = updateTransition(targetState = pagerState.currentPage, label = "")

        val rotationY by transition.animateFloat(label = "") { targetPage ->
            val pageOffset = (targetPage - page + pagerState.currentPageOffsetFraction).coerceIn(-1f, 1f)
            if (pageOffset < 0) {
                lerp(0f, 90f, pageOffset.absoluteValue)
            } else {
                lerp(0f, -90f, pageOffset)
            }
        }
        Box(modifier = modifier.graphicsLayer {
            this.rotationY = rotationY
        }) {
            Icon(imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoryScreenPreview() {
    InstagramUITheme {
        StoryScreen(modifier = Modifier.fillMaxSize(), index = 0)
    }
}