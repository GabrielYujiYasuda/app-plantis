package com.example.plantis.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.plantis.ui.screen.HomeScreen
import com.example.plantis.ui.screen.PlantsScreen
import com.example.plantis.ui.screen.SplashScreen
import com.example.plantis.ui.screen.routes.UIRoutes


@Composable
fun MyNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = UIRoutes.Splash.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(UIRoutes.Splash.route) {
            SplashScreen(onNavigateToHome = { navController.navigate(UIRoutes.Home.route) })
        }
        composable(UIRoutes.Home.route) {
            HomeScreen()
        }
        composable(UIRoutes.Plants.route) {
            PlantsScreen()
        }
        composable(UIRoutes.Notifications.route) {
            PlantsScreen()
        }
        composable(UIRoutes.Profile.route) {
            PlantsScreen()
        }
    }
}
