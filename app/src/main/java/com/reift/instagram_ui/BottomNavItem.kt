package com.reift.instagram_ui

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
){
    companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_EXPLORE = "route_explore"
        const val ROUTE_POST = "route_post"
        const val ROUTE_REELS = "route_reels"
        const val ROUTE_PROFILE = "route_profile"
    }
}
