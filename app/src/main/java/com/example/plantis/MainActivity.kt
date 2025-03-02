package com.example.plantis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeDrawing
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
