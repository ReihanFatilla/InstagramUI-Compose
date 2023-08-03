package com.reift.instagram_ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.`interface`.CommentListener
import com.reift.instagram_ui.model.Comment
import com.reift.instagram_ui.model.Post
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import com.webtoonscorp.android.readmore.material.ReadMoreText

fun LazyListScope.FeedsSection(commentListener: CommentListener) {
    items(Post.listPost) { post ->
        val modifier = Modifier.fillMaxWidth()
        Column(verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(horizontal = 16.dp)) {
            FeedsHeader(post = post, modifier = modifier)
            FeedsContent(post = post, modifier = modifier, commentListener = commentListener)
            FeedsFooter(post = post, modifier = modifier, commentListener = commentListener)
        }
    }
}

@Composable
fun FeedsComment(post: Post, commentListener: CommentListener) {
    Text(text = "View all ${post.listComment.size} comments", fontWeight = FontWeight.Normal, fontSize = 11.sp, color = Color.Gray, modifier = Modifier.clickable {
        commentListener.onClick(post.listComment)
    })
    Text(text = run {
        val comment = post.listComment.random()
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(comment.user.username)
            }
            append("\t${comment.message}")
        }
    }, fontSize = 12.sp)
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun FeedsFooter(post: Post, modifier: Modifier, commentListener: CommentListener) {
    val (expanded, onExpandedChange) = rememberSaveable { mutableStateOf(false) }
    LikedByRow(modifier, post)
    Column(modifier = modifier.padding(end = 32.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(modifier = modifier) {
            ReadMoreText(text = run {
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(post.user.username)
                    }
                    append(" ${post.caption}\n")
                    post.tags.forEach {
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("#$it ")
                        }
                    }
                }
            },
                softWrap = true,
                readMoreStyle = SpanStyle(color = Color.Gray),
                readMoreText = "more",
                fontSize = 12.sp,
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                readMoreMaxLines = 1
            )
        }
        FeedsComment(post = post, commentListener = commentListener)

    }
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
fun FeedsContent(post: Post, modifier: Modifier, commentListener: CommentListener) {
    Image(painter = rememberAsyncImagePainter(model = post.imageUrl),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .background(Color.Black),
        contentScale = ContentScale.Crop
    )
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
            Icon(imageVector = Icons.Outlined.Email, contentDescription = null, modifier = Modifier.clickable {
                commentListener.onClick(post.listComment)
            })
            Icon(imageVector = Icons.Outlined.Share, contentDescription = null)
        }
        Icon(imageVector = Icons.Outlined.Done, contentDescription = null)
    }
}

@Composable
fun FeedsHeader(modifier: Modifier, post: Post) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(model = post.user.profileUrl),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = post.user.username,
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
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            FeedsSection((object: CommentListener{
                override fun onClick(listComment: List<Comment>) {
                }
            }))
        }
    }
}