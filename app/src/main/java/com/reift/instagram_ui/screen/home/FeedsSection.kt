package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun FeedsSection() {
    val modifier = Modifier.fillMaxWidth()
    Spacer(modifier = Modifier.height(16.dp))
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
        items(Post.listPost) { post ->
            Column(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberAsyncImagePainter(model = post.profileUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .width(25.dp)
                                .aspectRatio(1f)
                                .clip(CircleShape)
                                .background(Color.Black)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = post.username, fontSize = 14.sp, color = Color.Black)
                    }
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
                Image(painter = rememberAsyncImagePainter(model = post.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                        .background(Color.Black))
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
                        Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
                        Icon(imageVector = Icons.Outlined.Share, contentDescription = null)
                    }
                    Icon(imageVector = Icons.Outlined.Done, contentDescription = null)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedsPreview() {
    InstagramUITheme {
        FeedsSection()
    }
}