package com.brave.shoppy.screen.cart.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.ui.theme.size

@Composable
fun CartItemReviewButton(
    modifier: Modifier = Modifier, onClick: () -> Unit, color: Color, icon: Int, colorTint: Color
) {
    val size = MaterialTheme.size
    Card(
        modifier = modifier
            .width(size.cartItemReviewButtonSize)
            .height(size.cartItemReviewButtonSize)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = color),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "CartItemReviewButton",
                tint = colorTint,
                modifier = Modifier
                    .height(MaterialTheme.size.cartItemReviewIconSize)
                    .width(MaterialTheme.size.cartItemReviewIconSize)
            )

        }
    }
}
