package com.example.plantis.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.plantis.ui.screen.HomeScreen
import com.example.plantis.ui.screen.PlantsScreen
import com.example.plantis.ui.screen.SplashScreen
import com.example.plantis.ui.screen.routes.Home
import com.example.plantis.ui.screen.routes.Plants
import com.example.plantis.ui.screen.routes.Splash


@Composable
fun MyNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = androidx.compose.ui.Modifier.padding(paddingValues)
    ) {
        composable<Splash> {
            SplashScreen(onNavigateToHome = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen()
        }

        composable<Plants> {
            PlantsScreen()
        }
    }
}
