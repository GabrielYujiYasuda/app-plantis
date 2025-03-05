package com.example.plantis.model.navigationItem

import androidx.annotation.DrawableRes
import com.example.plantis.R
import com.example.plantis.ui.screen.routes.UIRoutes

sealed class NavigationItem(
    val route: UIRoutes,
    val title: String,
    @DrawableRes val iconResId: Int,
    val badgeCount: Int? = null,
) {
    object Home : NavigationItem(UIRoutes.Home, "Home", R.drawable.ic_launcher_foreground)
    object Plants : NavigationItem(UIRoutes.Plants, "Plants", R.drawable.ic_launcher_foreground)
    object Notifications : NavigationItem(UIRoutes.Notifications, "Notifications", R.drawable.ic_launcher_foreground)
    object Profile : NavigationItem(UIRoutes.Profile, "Profile", R.drawable.ic_launcher_foreground)
}