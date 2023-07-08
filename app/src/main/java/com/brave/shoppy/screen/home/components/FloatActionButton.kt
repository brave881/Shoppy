package com.brave.shoppy.screen.home.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R


@Composable
fun FloatActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .height(68.dp)
            .width(68.dp),
        shape = RoundedCornerShape(size = 100.dp),

        ) {
        Icon(
            painter = painterResource(id = R.drawable.shopping_cart),
            contentDescription = "shopping cart icon",
        )
    }
}
