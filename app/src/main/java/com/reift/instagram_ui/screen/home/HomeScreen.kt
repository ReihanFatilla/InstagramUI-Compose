package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun HomeScreen(
    modifier: Modifier
){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item{
            HomeTopBar()
        }
        item{
            StorySection()
        }
        items(Post.listPost) { post ->
            FeedsSection(post)
        }

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