package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.reift.instagram_ui.screen.profile.screen.MyPostScreen
import com.reift.instagram_ui.screen.profile.screen.TagScreen
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.TabPagerSection(pagerState: PagerState) {
    stickyHeader {
        val scope = rememberCoroutineScope()
        TabProfile(pagerState) { index ->
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        }
    }
    item {
        HorizontalPagerProfile(pagerState)
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerProfile(pagerState: PagerState) {
    HorizontalPager(pageCount = 2, state = pagerState) { index ->
        val modifier = Modifier.fillMaxWidth()
        when (index) {
            0 -> MyPostScreen(modifier = modifier)
            1 -> TagScreen(modifier = modifier)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TabProfile(
    pagerState: PagerState,
    onClick: (Int) -> Unit,
) {
    TabRow(selectedTabIndex = pagerState.currentPage, backgroundColor = Color.White) {
        listOf(
            Icons.Default.List,
            Icons.Default.Person
        ).forEachIndexed { index, imageVector ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    onClick(index)
                },
                icon = {
                    Icon(imageVector = imageVector, contentDescription = null)
                },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabPagerPreview() {
    InstagramUITheme {
        val pagerState = rememberPagerState()
        LazyColumn {
            TabPagerSection(pagerState)
        }
    }
}