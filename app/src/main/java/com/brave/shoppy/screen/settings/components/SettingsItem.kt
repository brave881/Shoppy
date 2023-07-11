package com.brave.shoppy.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.brave.shoppy.utils.Chevron
import com.brave.shoppy.utils.smallCornerShape_5
import com.brave.shoppy.utils.largePadding_24
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallCardSize_24
import com.brave.shoppy.utils.smallIconSize_12
import com.brave.shoppy.utils.smallPadding_10

@Composable
fun SettingsItem(
    painter: Painter,
    text: String,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .clickable {
                onClick()
            }
            .padding(horizontal = largePadding_24, vertical = smallPadding_10)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                Modifier.size(smallCardSize_24),
                shape = RoundedCornerShape(smallCornerShape_5),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        modifier = Modifier.size(smallIconSize_12),
                        painter = painter,
                        contentDescription = ""
                    )
                }
            }
            Text(
                text = text,
                modifier = Modifier.padding(
                    start = primaryPadding
                )
            )
        }
        Chevron(size = smallCardSize_24, cornerShape = smallCornerShape_5)
    }
}
