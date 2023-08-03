package com.reift.instagram_ui.screen.home.screen.comment

import android.widget.Space
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.`interface`.CommentListener
import com.reift.instagram_ui.model.Comment
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CommentBottomSheet(content: @Composable (CommentListener) -> Unit) {
    var commentLiveData = MutableLiveData<List<Comment>>()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    val commentListener = object : CommentListener {
        override fun onClick(listComment: List<Comment>) {
            coroutineScope.launch {
                commentLiveData.postValue(listComment)
                sheetState.show()
            }
        }
    }

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { CommentScreen(Modifier.fillMaxSize(), commentLiveData) },
        modifier = Modifier.fillMaxSize(),
        content = { content(commentListener) }
    )
}

@Composable
fun CommentScreen(modifier: Modifier, commentLiveData: LiveData<List<Comment>>) {
    Card(
        modifier = modifier,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)) {
        Box(modifier = modifier) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier
                    .width(48.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .align(Alignment.CenterHorizontally))
                Text(text = "Comments",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                var listComment = commentLiveData.observeAsState().value ?: listOf()
                LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(listComment) { comment ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = comment.user.profileUrl),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(
                                            CircleShape
                                        )
                                        .background(Color.Black)
                                )
                                Spacer(Modifier.width(12.dp))
                                Column {
                                    Text(text = comment.user.username, fontSize = 12.sp)
                                    Text(text = comment.message, fontSize = 15.sp)
                                }
                            }
                            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }
            CommentFooter()
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CommentSheetPreview() {
    InstagramUITheme {
        CommentScreen(modifier = Modifier.fillMaxSize(), commentLiveData = MutableLiveData(Comment.listComment))
    }
}