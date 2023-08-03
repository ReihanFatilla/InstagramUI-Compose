package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.model.User
import com.reift.instagram_ui.screen.home.screen.comment.CommentBottomSheet
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    onStoryClick: (List<User>) -> Unit
) {
    CommentBottomSheet(modifier = modifier) { CommentListener ->
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
            HomeTopBar()
            StorySection()
            FeedsSection(CommentListener)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    InstagramUITheme {
        HomeScreen(modifier = Modifier
            .fillMaxSize()
            .clipToBounds(),
        ){}
    }
}