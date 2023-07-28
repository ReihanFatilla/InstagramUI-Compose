package com.reift.instagram_ui.screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExploreScreen(modifier: Modifier) {
    var query by remember { mutableStateOf("") }
    LazyColumn(modifier = modifier) {
        item {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null )},
                placeholder = { Text(text = "Search") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    InstagramUITheme {
        ExploreScreen(modifier = Modifier.fillMaxSize())
    }
}