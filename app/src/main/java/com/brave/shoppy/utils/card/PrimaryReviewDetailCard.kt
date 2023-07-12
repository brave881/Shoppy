package com.brave.shoppy.utils.card

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.size
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.Chevron

@Composable
fun PrimaryReviewDetailCard(
    title: String,
    subTitle: String,
    isAddress: Boolean = true,
    onClick: (() -> Unit)? = null,
    chevronIconColor: Boolean = true,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() },
        colors = CardDefaults.cardColors(), shape = MaterialTheme.shapes.extraLarge
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.size.mapCardItemHeight)
                .padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier) {
                Card(
                    modifier = Modifier
                        .height(MaterialTheme.size.mapCardIconSize)
                        .width(MaterialTheme.size.mapCardIconSize),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = if (isAddress) R.drawable.map_pin else R.drawable.credit_card),
                        contentDescription = "map pin icon",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(MaterialTheme.spacing.medium)
                    )


                }

                Column(modifier = Modifier.padding(start = MaterialTheme.spacing.small)) {
                    Text(
                        text = title,
                        style = if (isAddress) MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_regular)
                            )
                        ) else MaterialTheme.typography.displaySmall.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_bold)
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                    Text(
                        text = subTitle,
                        style = if (isAddress) MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_bold)
                            )
                        ) else MaterialTheme.typography.displaySmall.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_semi_bold)
                            )
                        )
                    )

                }
            }

            Chevron(isBlack = chevronIconColor)
        }


    }
}
