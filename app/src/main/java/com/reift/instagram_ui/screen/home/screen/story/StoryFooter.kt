package com.reift.instagram_ui.screen.home.screen.story

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Story

@Composable
fun StoryHeader(story: Story) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = story.user.profileUrl),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = story.user.username,
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
        Row {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Icon(imageVector = Icons.Default.Close, contentDescription = null, tint = Color.White)
        }
    }
}