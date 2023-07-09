package com.brave.shoppy.screen.settings.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.settingsHelpBackground
import com.brave.shoppy.utils.cornerShape_10
import com.brave.shoppy.utils.largeBottomPadding_34
import com.brave.shoppy.utils.largeCardSize_68
import com.brave.shoppy.utils.verticalPadding_12
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallBorder_1

@Composable
fun SettingsHelpCard(onClick: () -> Unit) {

    OutlinedCard(
        Modifier
            .padding(
                start = largeHorizontalPadding_24,
                end = largeHorizontalPadding_24,
                bottom = largeBottomPadding_34
            )
            .fillMaxWidth()
            .height(largeCardSize_68),
        shape = RoundedCornerShape(cornerShape_10),
        border = BorderStroke(width = smallBorder_1, color = MaterialTheme.colorScheme.primary),
    ) {
        Row(
            Modifier
                .background(color = settingsHelpBackground)
                .clickable { onClick() }
                .padding(start = verticalPadding_12)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.help_circle),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(start = primaryPadding),
                text = stringResource(R.string.feel_free_to_ask_we_ready_to_help),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}