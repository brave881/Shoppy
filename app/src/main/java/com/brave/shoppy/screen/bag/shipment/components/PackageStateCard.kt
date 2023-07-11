package com.brave.shoppy.screen.bag.shipment.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.utils.horizontalPadding_12
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.mediumCornerShape_10

@Composable
fun PackageStateCard(
    icon: Int,
    text: String,
    contentColor: Color,
    containerColor: Color
) {
    Card(
        Modifier
            .padding(horizontal = largeHorizontalPadding_24)
            .height(mediumCardSize_48)
            .fillMaxWidth(),
        shape = RoundedCornerShape(mediumCornerShape_10),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Row(
            Modifier
                .padding(horizontalPadding_12)
                .fillMaxWidth(),

            ) {
            Icon(painter = painterResource(id = icon), contentDescription = "")
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = text)
            }
        }
    }
}