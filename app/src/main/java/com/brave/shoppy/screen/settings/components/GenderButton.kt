package com.brave.shoppy.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.R
import com.brave.shoppy.utils.cornerShape_5
import com.brave.shoppy.utils.smallCardSize_24

@Composable
fun GenderButton(
    modifier: Modifier = Modifier,
    isMale: Boolean = true,
    isClicked: Boolean = false,
    onClick: () -> Unit
) {
    var cardColors = CardDefaults.cardColors()
    if (isClicked) cardColors =
        CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    Card(
        modifier = modifier.size(smallCardSize_24),
        shape = RoundedCornerShape(cornerShape_5),
        colors = cardColors
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            if (isMale) Icon(
                painter = painterResource(id = R.drawable.male), contentDescription = "male"
            )
            else Icon(
                painter = painterResource(id = R.drawable.female), contentDescription = "female"
            )
        }
    }
}
