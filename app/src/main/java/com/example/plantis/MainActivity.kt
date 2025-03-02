package com.example.plantis

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantis.model.navigationItem.NavigationItem
import com.example.plantis.ui.screen.HomeScreen
import com.example.plantis.ui.screen.SplashScreen
import com.example.plantis.ui.screen.routes.Home
import com.example.plantis.ui.screen.routes.Splash
import com.example.plantis.ui.theme.PlantisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantisTheme {
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                val navItems = listOf(
                    NavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Outlined.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false,
                    ),

                    NavigationItem(
                        title = "Plants",
                        selectedIcon = Icons.Outlined.Info,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false,
                    ),

                    NavigationItem(
                        title = "Notifications",
                        selectedIcon = Icons.Outlined.Notifications,
                        unselectedIcon = Icons.Outlined.Notifications,
                        hasNews = false,
                        badgeCount = 9
                    ),

                    NavigationItem(
                        title = "Profile",
                        selectedIcon = Icons.Outlined.AccountCircle,
                        unselectedIcon = Icons.Outlined.AccountCircle,
                        hasNews = false,
                    )
                )

                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            navItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    label = { Text(text = item.title) },
                                    onClick = {
                                        selectedItemIndex = index
                                        navController.navigate(item.title)
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if (item.badgeCount != null) {
                                                    Badge {
                                                        Text(text = item.badgeCount.toString())
                                                    }
                                                }
                                                else if (item.hasNews) {
                                                    Badge()
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title,
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    },
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Splash,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable<Splash> {
                            SplashScreen(onNavigateToHome = {
                                navController.navigate(Home)
                            })
                        }

                        composable<Home> {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
