package com.example.plantis.model.navigationItem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: Any,
    val badgeCount: Int? = null,
) {
    data object Home : NavigationItem(
        title = "Home",
        icon =  Icons.Outlined.Home,
        route = "Home",
    )

    data object Plants : NavigationItem(
        title = "Plants",
        route = Icons.Outlined.Build,
        icon = Icons.Outlined.Call,
    )

    data object Notifications : NavigationItem(
        title = "Notifications",
        route = Home,
        icon = Icons.Outlined.Notifications,
        badgeCount = 9,
    )
    data object Profile : NavigationItem(
        title = "Profile",
        route = Home,
        icon = Icons.Outlined.Person,
    )
}