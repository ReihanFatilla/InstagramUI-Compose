package com.reift.instagram_ui.screen.home.screen.story

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Story
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import com.reift.instagram_ui.utils.storySwipeAnimation

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(index: Int, modifier: Modifier) {
    val pagerState = rememberPagerState(index)
    HorizontalPager(
        modifier = modifier,
        pageCount = Story.listStory.size,
        state = pagerState
    ) { page ->
        val story = Story.listStory[page]

        Box(modifier = modifier.storySwipeAnimation(pagerState, page)) {
            Image(
                painter = rememberAsyncImagePainter(model = story.imageUrl),
                contentDescription = null,
                modifier = modifier
                    .background(Color.Black)
            )
            Column(
                modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                StoryHeader(story)
                StoryFooter()
            }
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