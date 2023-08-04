package com.reift.instagram_ui.screen.home.screen.story

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StoryFooter() {
    var text by remember { mutableStateOf("") }
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White, focusedBorderColor = Color.White),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(50.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Face,
                    contentDescription = null)
            },
            placeholder = {
                Text(text = "Send message...", color = Color.Gray)
            })
        Icon(imageVector = Icons.Outlined.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
    }
}