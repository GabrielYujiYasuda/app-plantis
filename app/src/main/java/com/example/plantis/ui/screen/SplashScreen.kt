package com.example.plantis.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantis.ui.theme.PlantisTypography
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        onNavigateToHome()
    }

    Column(
        modifier = modifier
            .background(color = Color.Gray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        //TODO: Implement our logo here
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = PlantisTypography.titleLarge,
            textAlign = TextAlign.Center,
            text = "PLANTIS"
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(onNavigateToHome = { })
}