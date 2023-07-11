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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.brave.shoppy.utils.smallCornerShape_5
import com.brave.shoppy.utils.largePadding_24
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallCardSize_24
import com.brave.shoppy.utils.smallIconSize_12
import com.brave.shoppy.utils.smallPadding_10

@Composable
fun SettingsItemWithToggle(
    painter: Painter,
    switchState: Boolean,
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    onCheckedChange: (Boolean) -> Unit,
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
                colors = CardDefaults.cardColors(containerColor = backgroundColor)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        modifier = Modifier.size(smallIconSize_12),
                        painter = painter,
                        tint = MaterialTheme.colorScheme.onTertiary,
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
        Switch(
            modifier = Modifier.size(width = mediumCardSize_48, height = smallCardSize_24),
            checked = switchState,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                uncheckedBorderColor = Color.Unspecified,
                uncheckedThumbColor = MaterialTheme.colorScheme.onTertiary
            )
        )
    }
}
