package com.brave.shoppy.screen.oreder_review.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.ui.theme.size

@Composable
fun OrderReviewImageItem(
    modifier: Modifier = Modifier, image: Int
) {
    Card(
        modifier = modifier.size(MaterialTheme.size.orderReviewImageItemSize),
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Order Review Image Item",
            modifier = Modifier.fillMaxSize()
        )
    }
}
