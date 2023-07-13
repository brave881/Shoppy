package com.brave.shoppy.utils.card

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
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.mediumCornerShape_10

@Composable
fun ImageCard(
    modifier: Modifier = Modifier.size(mediumCardSize_48),
    shape: Shape = RoundedCornerShape(mediumCornerShape_10),
    image: Int
) {
    Card(
        modifier = modifier, shape = shape,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
        )
    }
}
