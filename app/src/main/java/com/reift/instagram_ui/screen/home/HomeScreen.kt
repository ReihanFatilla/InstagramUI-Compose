package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun HomeScreen(
    modifier: Modifier
){
    Column(modifier = modifier) {
        HomeTopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    InstagramUITheme {
        HomeScreen(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 16.dp))
    }
}