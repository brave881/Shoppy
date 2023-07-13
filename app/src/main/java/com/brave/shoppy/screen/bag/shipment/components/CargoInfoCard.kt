package com.brave.shoppy.screen.bag.shipment.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.ui.theme.styleCargoDeliverDate_16
import com.brave.shoppy.ui.theme.styleCargoName_16
import com.brave.shoppy.utils.card.ImageCard
import com.brave.shoppy.utils.cardPadding_20
import com.brave.shoppy.utils.largeCornerShape_15
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.mediumCardSize_60
import com.brave.shoppy.utils.smallPadding_10
import com.brave.shoppy.utils.xLargeCardSize_100

@Composable
fun CargoInfoCard(
    image: Int,
    name: String,
    onClick: () -> Unit,
    text: String,
) {
    Card(
        Modifier
            .padding(horizontal = largeHorizontalPadding_24)
            .fillMaxWidth()
            .height(xLargeCardSize_100),
        shape = RoundedCornerShape(largeCornerShape_15),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F24))
    ) {
        Row(
            Modifier
                .clickable { onClick() }
                .padding(cardPadding_20)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageCard(
                image = image, modifier = Modifier.size(
                    mediumCardSize_60
                ), shape = RoundedCornerShape(largeCornerShape_15)
            )
            Column(
                Modifier
                    .padding(start = smallPadding_10)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = name, style = styleCargoName_16)
                Text(text = text, style = styleCargoDeliverDate_16)
            }
        }
    }
}