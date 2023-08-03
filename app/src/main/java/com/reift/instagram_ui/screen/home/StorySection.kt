package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.reift.instagram_ui.model.User


fun LazyListScope.StorySection(onStoryClick: (Int) -> Unit) {
    item {
        StoryLazyRow(listUser = Story.listStory, profileSize = 90, fontSize = 12, isActive = true, onStoryClick)
    }
}

@Composable
fun StoryLazyRow(
    listUser: List<Story>,
    profileSize: Int,
    fontSize: Int,
    isActive: Boolean,
    onStoryClick: (Int) -> Unit
){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(listUser) { story ->
            Column(modifier = Modifier.width(profileSize.dp).clickable {
                onStoryClick(listUser.indexOf(story))
            }) {
                Image(
                    painter = rememberAsyncImagePainter(model = story.user.profileUrl),
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
                Text(text = story.user.username,
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