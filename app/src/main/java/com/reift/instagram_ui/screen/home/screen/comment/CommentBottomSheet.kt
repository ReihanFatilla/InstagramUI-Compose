package com.reift.instagram_ui.screen.home.screen.comment

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    val commentListener = object: CommentListener{
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
        sheetContent = { CommentScreen() },
        modifier = Modifier.fillMaxSize(),
        content = { content(commentListener) }
    )
}

@Composable
fun CommentScreen() {

}

@Preview(showBackground = true)
@Composable
fun CommentSheetPreview() {
    InstagramUITheme {
        CommentBottomSheet {
            Button(onClick = { it.onClick() }) {
                Text(text = "Show Comment")
            }
        }
    }
}