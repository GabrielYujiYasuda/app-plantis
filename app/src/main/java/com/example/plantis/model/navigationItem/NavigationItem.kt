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
    object Home : NavigationItem(UIRoutes.Home, "Garden", R.drawable.house)
    object Plants : NavigationItem(UIRoutes.Plants, "Plants", R.drawable.potted_plant)
    object Notifications : NavigationItem(UIRoutes.Notifications, "Notifications", R.drawable.bell_simple, 9)
    object Profile : NavigationItem(UIRoutes.Profile, "Profile", R.drawable.user)
}