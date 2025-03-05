package com.example.plantis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantis.navigation.MyNavGraph
import com.example.plantis.ui.shared.MyNavigationBar
import com.example.plantis.ui.theme.PlantisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantisTheme {
                val navController = rememberNavController()
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { MyNavigationBar(
                        navController = navController,
                        currentRoute = currentRoute,
                    ) },
                ) { paddingValues ->
                    MyNavGraph(
                        paddingValues = paddingValues,
                        navController = navController,
                    )
                }
            }
        }
    }
}
