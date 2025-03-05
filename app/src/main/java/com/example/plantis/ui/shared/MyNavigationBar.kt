package com.example.plantis.ui.shared

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.plantis.model.navigationItem.NavigationItem

@Composable
fun MyNavigationBar(
    navController: NavHostController,
    currentRoute: String? = null,
) {
    NavigationBar {
        val navItems = listOf(
            NavigationItem.Home,
            NavigationItem.Plants,
            NavigationItem.Notifications,
            NavigationItem.Profile,
        )

        navItems.forEach { item ->
            val isSelected = currentRoute?.substringBefore("?") == item.route::class.qualifiedName


            NavigationBarItem(
                selected = isSelected,
                label = { Text(text = item.title) },
                onClick = { navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { startRoute ->
                        popUpTo(startRoute) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                } },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                            else  {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                        )
                    }
                }
            )
        }
    }
}