package com.brave.shoppy.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R


@Composable
fun PrimaryTextButton(
    letter: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onSelected: Boolean = false

) {
    Card(
        modifier = modifier
            .width(48.dp)
            .height(48.dp), shape = RoundedCornerShape(
            topStart = 10.dp, topEnd = 0.dp, bottomEnd = 10.dp, bottomStart = 10.dp,
        ), colors = CardDefaults.cardColors(
            containerColor = if (onSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = letter,
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold)),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
