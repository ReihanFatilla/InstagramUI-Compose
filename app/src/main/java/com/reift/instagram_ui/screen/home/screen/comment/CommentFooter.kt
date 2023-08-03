package com.reift.instagram_ui.screen.home.screen.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun BoxScope.CommentFooter() {
    var text by remember { mutableStateOf("") }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(Color.White)
            .padding(all = 16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://pbs.twimg.com/media/CVUcE1_UsAAXzZV.png"),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Black)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Gray),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Face,
                    contentDescription = null)
            },
            placeholder = {
                Text(text = "Add your comment...", color = Color.Gray)
            })
    }
}