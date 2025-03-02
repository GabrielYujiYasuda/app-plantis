package com.example.plantis.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantis.ui.theme.GreenDark
import com.example.plantis.ui.theme.PlantisTypography
import com.example.plantis.ui.theme.YellowLight

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = YellowLight),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            color = GreenDark,
            style = PlantisTypography.headlineLarge,
            textAlign = TextAlign.Center,
            text = "This is the Home Screen"
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}