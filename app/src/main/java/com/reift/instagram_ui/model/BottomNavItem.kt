package com.reift.instagram_ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val icon: ImageVector
){
    companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_EXPLORE = "route_explore"
        const val ROUTE_POST = "route_post"
        const val ROUTE_REELS = "route_reels"
        const val ROUTE_PROFILE = "route_profile"

        val listNavItem = listOf(
            BottomNavItem(ROUTE_HOME, Icons.Default.Home),
            BottomNavItem(ROUTE_EXPLORE, Icons.Default.Search),
            BottomNavItem(ROUTE_POST, Icons.Default.Add),
            BottomNavItem(ROUTE_REELS, Icons.Default.PlayArrow),
            BottomNavItem(ROUTE_PROFILE, Icons.Default.AccountCircle)
        )
    }
}
