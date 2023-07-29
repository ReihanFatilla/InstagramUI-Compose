package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileTabBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,) {
        LeadingIcon()
        ActionIcon()
    }
}

@Composable
private fun ActionIcon() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(imageVector = Icons.Outlined.Add,
            contentDescription = null,
            modifier = Modifier.border(2.dp, Color.Black, RoundedCornerShape(5.dp))
        )
        Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
    }
}

@Composable
private fun LeadingIcon() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)
        Text(text = "reihanfatilla", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
    }
}