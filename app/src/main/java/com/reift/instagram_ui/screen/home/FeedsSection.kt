package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import com.webtoonscorp.android.readmore.foundation.BasicReadMoreText

@Composable
fun FeedsSection(post: Post) {
    val modifier = Modifier.fillMaxWidth()
    Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        FeedsHeader(post = post, modifier = modifier)
        FeedsContent(post = post, modifier = modifier)
        FeedsFooter(post = post, modifier = modifier)
    }
}

@Composable
fun FeedsFooter(post: Post, modifier: Modifier) {
    LikedByRow(modifier, post)
    Row(modifier = modifier.padding(end = 64.dp)) {
        BasicReadMoreText(text = run {
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(post.username)
                }

                append(" ${post.caption}\n")
                post.tags.forEach {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("#$it ")
                    }
                }
            }
        },
            expanded = false,
            softWrap = true,
            readMoreStyle = SpanStyle(color = Color.Gray),
            readMoreText = "more",
            readMoreMaxLines = 1
        )
    }

    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun LikedByRow(modifier: Modifier, post: Post) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(modifier = Modifier.width((20 + (10 * (post.likedBy.size - 1))).dp)) {
            post.likedBy.forEachIndexed { index, story ->
                Image(
                    painter = rememberAsyncImagePainter(model = story.profileUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = (10 * (index)).dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                        .background(Color.Black)
                )
            }
        }
        Text(text = "Liked by", fontWeight = FontWeight.Normal, fontSize = 12.sp)
        Text(text = post.likedBy.first().username, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text(text = "and", fontWeight = FontWeight.Normal, fontSize = 12.sp)
        Text(text = "others", fontWeight = FontWeight.Bold, fontSize = 12.sp)
    }
}

@Composable
fun FeedsContent(post: Post, modifier: Modifier) {
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

@Composable
fun FeedsHeader(modifier: Modifier, post: Post) {
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
            Text(text = post.username,
                fontSize = 13.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun FeedsPreview() {
    InstagramUITheme {
        FeedsSection(post = Post.listPost.random())
    }
}