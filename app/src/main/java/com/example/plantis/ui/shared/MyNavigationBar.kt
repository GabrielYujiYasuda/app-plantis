package com.example.plantis.ui.shared

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.plantis.model.navigationItem.NavigationItem
import com.example.plantis.ui.screen.routes.Home
import com.example.plantis.ui.screen.routes.Plants

@Composable
fun MyNavigationBar(navController: NavHostController) {
    //region: Bottom Nav Data
    val navItems = listOf(
        NavigationItem(
            title = "HomeScreen",
            selectedIcon = Icons.Outlined.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),

        NavigationItem(
            title = "PlantsScreen",
            selectedIcon = Icons.Outlined.Info,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),

        NavigationItem(
            title = "HomeScreen",
            selectedIcon = Icons.Outlined.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            hasNews = false,
            badgeCount = 9,
        ),

        NavigationItem(
            title = "HomeScreen",
            selectedIcon = Icons.Outlined.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasNews = false,
        )
    )
    //endregion

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

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
}