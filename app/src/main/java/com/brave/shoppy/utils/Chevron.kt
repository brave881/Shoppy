package com.brave.shoppy.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R

@Composable
fun Chevron(
    size: Dp = mediumCardSize_48,
    cornerShape: Dp = cornerShape_10,
) {
    Card(Modifier.size(size), shape = RoundedCornerShape(cornerShape)) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.chevron_right),
                contentDescription = "edit"
            )
        }
    }
}