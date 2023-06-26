package com.brave.shoppy.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ItemCategory(
    background: Color,
    image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(48.dp)
            .height(48.dp), shape = RoundedCornerShape(
            topStart = 10.dp, topEnd = 0.dp, bottomEnd = 10.dp, bottomStart = 10.dp,
        ), colors = CardDefaults.cardColors(background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Category item",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
    }
}
