package com.reift.instagram_ui.screen.profile.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.reift.instagram_ui.screen.explore.PostSection

@Composable
fun MyPostScreen(modifier: Modifier){
    LazyColumn(modifier = modifier) {
        PostSection()
    }
}