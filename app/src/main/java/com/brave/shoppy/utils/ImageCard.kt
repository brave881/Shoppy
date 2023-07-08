package com.brave.shoppy.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.brave.shoppy.R

@Composable
fun ImageCard(
    size: Dp = mediumCardSize_48,
    shape: Shape = RoundedCornerShape(cornerShape_10),
    image: Painter
) {
    Card(
        modifier = Modifier.size(size), shape = shape,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
        )
    }
}