package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(modifier: Modifier) {
    val pagerState = rememberPagerState()
    Scaffold(
        modifier = modifier,
        topBar =  { ProfileTopBar() }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            BiodataSection()
            TabPagerSection(pagerState = pagerState)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    InstagramUITheme {
        ProfileScreen(modifier = Modifier.fillMaxSize())
    }
}