package com.example.plantis.ui.screen.routes

sealed class UIRoutes(val route: String) {
    object Splash : UIRoutes("splash")
    object Home : UIRoutes("home")
    object Plants : UIRoutes("plants")
    object Notifications : UIRoutes("notifications")
    object Profile : UIRoutes("profile")
}