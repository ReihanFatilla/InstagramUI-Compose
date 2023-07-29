package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.reift.instagram_ui.screen.home.HomeScreen
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun ProfileScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        ProfileTabBar()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    InstagramUITheme {
        ProfileScreen(modifier = Modifier.fillMaxSize())
    }
}