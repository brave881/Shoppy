package com.brave.shoppy.utils.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.mediumIconSize_24

@Composable
fun PrimaryImageButton(
    image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isClicked: Boolean = false,
    backgroundColor: Color = primaryTextFieldBackground
) {
    val cardColors =
        if (isClicked) CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        else CardDefaults.cardColors(containerColor = backgroundColor)
    Card(
        modifier = modifier
            .size(mediumCardSize_48),
        shape = RoundedCornerShape(
            topStart = 10.dp,
            topEnd = 0.dp,
            bottomEnd = 10.dp,
            bottomStart = 10.dp,
        ), colors = cardColors
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
                modifier = Modifier.size(mediumIconSize_24)
            )
        }
    }

}
