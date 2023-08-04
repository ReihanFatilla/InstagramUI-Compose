package com.reift.instagram_ui.screen.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.screen.explore.PostSection

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagScreen(modifier: Modifier){
    FlowRow {
        Post.listPost.map { it.imageUrl }.forEach { imageUrl ->
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.333f)
                    .aspectRatio(1f)
                    .padding(1.dp)
                    .background(Color.Black),
                contentScale = ContentScale.Crop
            )
        }
    }
}