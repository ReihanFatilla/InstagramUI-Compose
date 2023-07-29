package com.reift.instagram_ui.screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Post

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.PostSection() {
    item {
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
}
