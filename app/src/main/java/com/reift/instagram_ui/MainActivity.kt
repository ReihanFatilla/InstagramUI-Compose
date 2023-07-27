package com.reift.instagram_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.reift.instagram_ui.explore.ExploreScreen
import com.reift.instagram_ui.home.HomeScreen
import com.reift.instagram_ui.post.PostScreen
import com.reift.instagram_ui.profile.ProfileScreen
import com.reift.instagram_ui.reels.ReelsScreen
import com.reift.instagram_ui.ui.theme.InstagramUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUITheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                item = BottomNavItem.listNavItem,
                navController = navController,
            ) {
                navController.navigate(it.route)
            }
        }
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.ROUTE_HOME) {
        val modifier = Modifier.fillMaxSize()
        composable(BottomNavItem.ROUTE_HOME) {
            HomeScreen(modifier)
        }
        composable(BottomNavItem.ROUTE_EXPLORE) {
            ExploreScreen(modifier)
        }
        composable(BottomNavItem.ROUTE_POST) {
            PostScreen(modifier)
        }
        composable(BottomNavItem.ROUTE_REELS) {
            ReelsScreen(modifier)
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
    onItemClick: (BottomNavItem) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 2.dp
    ) {
        item.forEach {
            val selectedItem = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selectedItem,
                onClick = {
                    onItemClick(it)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.DarkGray,
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
        MainScreen()
    }
}