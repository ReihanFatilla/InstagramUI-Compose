package com.reift.instagram_ui.utils

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.storySwipeAnimation(pagerState: PagerState, page: Int,): Modifier {
    val transition = updateTransition(targetState = pagerState.currentPage, label = "")
    val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

    val rotation by transition.animateFloat(label = "") { targetPage ->
        val pageOffset =
            (targetPage - page + pagerState.currentPageOffsetFraction).coerceIn(-1f, 1f)
        if (pageOffset < 0) {
            lerp(0f, 45f, pageOffset.absoluteValue)
        } else {
            lerp(0f, -45f, pageOffset.absoluteValue)
        }
    }

    val scale =
        lerp(
            start = 0.6f,
            stop = 1f,
            fraction = 1f - pageOffset.coerceIn(0f, 1f)
        )

    return this.then(Modifier.graphicsLayer {
        rotationY = rotation
        scaleX = scale
        scaleY = scale
    })
}