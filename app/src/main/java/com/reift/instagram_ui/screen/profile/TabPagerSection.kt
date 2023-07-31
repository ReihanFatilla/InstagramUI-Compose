package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabPagerSection() {
    val pagerState = rememberPagerState(0)
    val scope = rememberCoroutineScope()
    TabProfile(pagerState, scope)

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TabProfile(
    pagerState: PagerState,
    scope: CoroutineScope,
) {
    TabRow(selectedTabIndex = pagerState.currentPage, backgroundColor = Color.White) {
        listOf(Icons.Default.List,
            Icons.Default.Person).forEachIndexed { index, imageVector ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                icon = {
                    Icon(imageVector = imageVector, contentDescription = null)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPagerPreview() {
    InstagramUITheme {
        TabPagerSection()
    }
}