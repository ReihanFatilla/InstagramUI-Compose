package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Story


fun LazyListScope.StorySection() {
    item {
        StoryLazyRow(listStory = Story.listStory, profileSize = 90, fontSize = 12, isActive = true)
    }
}

@Composable
fun StoryLazyRow(listStory: List<Story>, profileSize: Int, fontSize: Int, isActive: Boolean){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(listStory) { story ->
            Column(modifier = Modifier.width(profileSize.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(model = story.profileUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .border(2.dp, if(isActive) Color.Red else Color.LightGray, CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(Color.Black)

                )
                Text(text = story.username,
                    fontSize = fontSize.sp,
                    color = Color.Black,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally))
            }
        }
    }
}