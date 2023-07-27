package com.reift.instagram_ui

data class BottomNavItem(
    val route: String,
){
    companion object {
        const val ROUTE_HOME = "route_home"
        const val ROUTE_EXPLORE = "route_explore"
        const val ROUTE_POST = "route_post"
        const val ROUTE_REELS = "route_reels"
        const val ROUTE_PROFILE = "route_profile"
    }
}
