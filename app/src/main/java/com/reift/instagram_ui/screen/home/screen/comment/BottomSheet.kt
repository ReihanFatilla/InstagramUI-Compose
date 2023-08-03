package com.reift.instagram_ui.screen.home.screen.comment

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.reift.instagram_ui.`interface`.CommentListener
import com.reift.instagram_ui.ui.theme.InstagramUITheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CommentBottomSheet(content: @Composable (CommentListener) -> Unit) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    val commentListener = object : CommentListener {
        override fun onClick() {
            coroutineScope.launch {
                sheetState.show()
            }
        }
    }

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { CommentScreen(Modifier.fillMaxSize()) },
        modifier = Modifier.fillMaxSize(),
        content = { content(commentListener) }
    )
}

@Composable
fun CommentScreen(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    Card(modifier = modifier, backgroundColor = Color.White, shape = RoundedCornerShape(15.dp)) {
        Box(modifier = modifier) {
            Column(modifier = Modifier) {

            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(all = 16.dp))
            {
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
                    onValueChange = { text = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Gray),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Face, contentDescription = null)},
                    placeholder = {
                        Text(text = "Add your comment...", color = Color.Gray)
                    })
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CommentSheetPreview() {
    InstagramUITheme {
        CommentScreen(modifier = Modifier.fillMaxSize())
    }
}