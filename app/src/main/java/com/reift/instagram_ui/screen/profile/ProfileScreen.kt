package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun ProfileScreen(modifier: Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ProfileTopBar()
        BiodataSection()
        TabPagerSection()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    InstagramUITheme {
        ProfileScreen(modifier = Modifier.fillMaxSize())
    }
}