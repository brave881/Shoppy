package com.brave.shoppy.screen.address.components

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
fun AddressDetailCard(
    city: String, street: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.size.mapCardItemHeight)
                .padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    //                                        .padding(start = MaterialTheme.spacing.medium)
                    .height(MaterialTheme.size.mapCardIconSize)
                    .width(MaterialTheme.size.mapCardIconSize),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.map_pin),
                    contentDescription = "map pin icon",
                    modifier = Modifier

                        .fillMaxSize()
                        .padding(MaterialTheme.spacing.medium)
                )


            }

            Column() {
                Text(
                    text = city,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = FontFamily(
                            Font(R.font.nunito_regular)
                        )
                    )
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                Text(
                    text = street,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily(
                            Font(R.font.nunito_bold)
                        )
                    )
                )

            }

            Chevron(isBlack = true)
        }


    }
}
