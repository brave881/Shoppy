package com.brave.shoppy.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.brave.shoppy.R

@Composable
fun Chevron(
    size: Dp = mediumCardSize_48,
    cornerShape: Dp = cornerShape_10,
    isBlack: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.size(size),
        shape = RoundedCornerShape(cornerShape),
        colors = CardDefaults.cardColors(containerColor = if (isBlack) Color.Black else Color.White)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.chevron_right),
                contentDescription = "edit", tint = if (isBlack) Color.White else Color.Black
            )
        }
    }
}
