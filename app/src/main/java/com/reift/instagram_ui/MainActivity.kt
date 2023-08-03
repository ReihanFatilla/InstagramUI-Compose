package com.reift.instagram_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.reift.instagram_ui.model.BottomNavItem
import com.reift.instagram_ui.screen.explore.ExploreScreen
import com.reift.instagram_ui.screen.home.HomeScreen
import com.reift.instagram_ui.screen.home.screen.story.StoryScreen
import com.reift.instagram_ui.screen.post.PostScreen
import com.reift.instagram_ui.screen.profile.ProfileScreen
import com.reift.instagram_ui.screen.reels.ReelsScreen
import com.reift.instagram_ui.ui.theme.InstagramUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUITheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.White,
                        darkIcons = true
                    )
                }
                MainScreen(systemUiController)
            }
        }
    }
}

@Composable
fun MainScreen(systemUiController: SystemUiController) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                item = BottomNavItem.listNavItem,
                navController = navController,
            ) {
                navController.navigate(it.route)
                isDarkMode(it.route, systemUiController)
            }
        },
    ) { paddingValues ->
        Navigation(navController = navController, modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues))
    }
}

fun isDarkMode(route: String, systemUiController: SystemUiController): Boolean {
    val isDarkMode = route == BottomNavItem.ROUTE_REELS
    if (isDarkMode) {
        systemUiController.setStatusBarColor(
            color = Color.Black,
            darkIcons = false
        )

    } else {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }
    return isDarkMode
}

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = BottomNavItem.ROUTE_HOME) {
        composable(BottomNavItem.ROUTE_HOME) {
            HomeScreen(modifier){
                navController.navigate("storyscreen/${it}")
            }
        }
        composable(
            route = "storyscreen/{index}",
            arguments = listOf(
                navArgument("index") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            StoryScreen(
                it.arguments?.getInt("index") ?: 0,
                Modifier.fillMaxSize()
            )
        }
        composable(BottomNavItem.ROUTE_EXPLORE) {
            ExploreScreen(modifier)
        }
        composable(BottomNavItem.ROUTE_POST) {
            PostScreen(modifier)
        }
        composable(BottomNavItem.ROUTE_REELS) {
            ReelsScreen(modifier.background(Color.Black))
        }
        composable(BottomNavItem.ROUTE_PROFILE) {
            ProfileScreen(modifier)
        }
    }
}

@Composable
fun BottomNavigationBar(
    item: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Boolean,
) {
    var isDark by remember { mutableStateOf(false) }
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = if (isDark) Color.Black else Color.White,
        elevation = 2.dp
    ) {
        item.forEach {
            val selectedItem = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selectedItem,
                onClick = {
                    isDark = onItemClick(it)
                },
                selectedContentColor = if (isDark) Color.White else Color.Black,
                unselectedContentColor = if (isDark) Color.DarkGray else Color.LightGray,
                icon = {
                    Icon(imageVector = it.icon, contentDescription = null)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramUITheme {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = Color.White,
                darkIcons = true
            )
        }
        MainScreen(systemUiController)
    }
}