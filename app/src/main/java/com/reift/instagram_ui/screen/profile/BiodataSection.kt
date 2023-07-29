package com.reift.instagram_ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.ui.theme.InstagramUITheme

@Composable
fun BiodataSection() {
    val modifier = Modifier.fillMaxWidth()
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        StatsRow(modifier)
        BiodataRow()
    }
}

@Composable
fun BiodataRow() {
    Text(text = "Reihan", fontSize = 14.sp, fontWeight = FontWeight.Bold)
}

@Composable
private fun StatsRow(modifier: Modifier) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PhotoBox()

        StatsColumn("12", "Posts")
        StatsColumn("492", "Followers")
        StatsColumn("342", "Following")
    }
}

@Composable
fun PhotoBox() {
    Box {
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://pbs.twimg.com/media/CVUcE1_UsAAXzZV.png"
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .background(Color.Black),
        )
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color.Blue)
                .border(2.dp, Color.White, CircleShape)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun StatsColumn(count: String, title: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = count, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileBioDataPreview() {
    InstagramUITheme {
        BiodataSection()
    }
}
