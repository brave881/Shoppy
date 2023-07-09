package com.brave.shoppy.screen.settings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.LanguageType
import com.brave.shoppy.utils.betweenTextPadding
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.cornerShape_10
import com.brave.shoppy.utils.largeCardSize_68
import com.brave.shoppy.utils.medium
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.small
import com.brave.shoppy.utils.smallCardSize_24

@Composable
fun LanguageButton(
    modifier: Modifier = Modifier,
    text: String,
    languageType: LanguageType,
    isClicked: Boolean = false,
    onClick: () -> Unit
) {
    var cardColors = CardDefaults.cardColors()
    if (isClicked) cardColors =
        CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    Card(
        modifier = modifier
            .padding(bottom = bottomPadding_20)
            .height(largeCardSize_68)
            .fillMaxWidth(),
        shape = RoundedCornerShape(cornerShape_10),
        colors = cardColors,
    ) {

        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(start = bottomPadding_20)
                .fillMaxSize(), verticalAlignment = Alignment.CenterVertically
        ) {
            when (languageType) {
                LanguageType.ENGLISH -> {
                    Image(
                        modifier = Modifier.size(smallCardSize_24),
                        painter = painterResource(id = R.drawable.english),
                        contentDescription = "male"
                    )
                }

                LanguageType.THAILAND -> {
                    Image(
                        modifier = Modifier.size(smallCardSize_24),
                        painter = painterResource(id = R.drawable.thailand2),
                        contentDescription = "male"
                    )
                }

                LanguageType.INDONESIAN -> {
                    Image(
                        modifier = Modifier.size(smallCardSize_24),
                        painter = painterResource(id = R.drawable.indonesian),
                        contentDescription = "male"
                    )
                }
            }

            Text(
                modifier = Modifier.padding(start = bottomPadding_20),
                text = text,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}