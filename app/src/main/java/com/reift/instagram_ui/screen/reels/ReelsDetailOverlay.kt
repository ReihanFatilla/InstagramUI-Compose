package com.reift.instagram_ui.screen.reels

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Reels
import com.reift.instagram_ui.model.User

@Composable
fun ReelsDetailOverlay(reels: Reels, modifier: Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
    ) {
        UserRow(reels)
        Text(text = reels.caption, fontSize = 12.sp, color = Color.White)
        LikedByRow(modifier = Modifier , likedBy = reels.likedBy)
    }
}

@Composable
private fun UserRow(reels: Reels) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = reels.user.profileUrl),
            contentDescription = null,
            modifier = Modifier
                .width(25.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = reels.user.username,
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedButton(
            onClick = { },
            modifier = Modifier.height(28.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.White),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        ) {
            Text(text = "Follow", fontSize = 10.sp, color = Color.White)
        }
    }
}

@Composable
fun LikedByRow(modifier: Modifier, likedBy: List<User>) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(modifier = Modifier.width((20 + (10 * (likedBy.size - 1))).dp)) {
            likedBy.forEachIndexed { index, story ->
                Image(
                    painter = rememberAsyncImagePainter(model = story.profileUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = (10 * (index)).dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                        .background(Color.White)
                )
            }
        }
        Text(text = "Liked by",
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.White)
        Text(text = likedBy.first().username,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White)
        Text(text = "and", fontWeight = FontWeight.Normal, fontSize = 12.sp, color = Color.White)
        Text(text = "others", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White)
    }
}