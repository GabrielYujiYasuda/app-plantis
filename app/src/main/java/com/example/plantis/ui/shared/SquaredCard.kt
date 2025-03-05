package com.example.plantis.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantis.ui.theme.GreenLight
import com.example.plantis.R

@Composable
fun SquaredCard(isAddCard: Boolean = false) {
    Column (
        modifier = Modifier
            .padding(8.dp)
            .background(color = GreenLight)
            .height(50.dp)
            .width(50.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        if (isAddCard) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
            )
        } else {
            Text(
                text = "Squared Card",
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
private fun SquaredCardPreview01() {
    SquaredCard(isAddCard = true)
}

@Preview
@Composable
private fun SquaredCardPreview() {
    SquaredCard()
}