package com.brave.shoppy.screen.bag.shipment.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.borderGrayColor
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.bottomPadding_32
import com.brave.shoppy.utils.halfWidthArc_55
import com.brave.shoppy.utils.largeArcPadding_39
import com.brave.shoppy.utils.largeCardSize_78
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.largeIconSize_30
import com.brave.shoppy.utils.largeVerticalPadding_24
import com.brave.shoppy.utils.mediumBorder_2
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.verticalPadding_12
import com.brave.shoppy.utils.widthArc_110
import com.brave.shoppy.utils.xLargeCardSize_188
import com.brave.shoppy.utils.xLargeCornerShape_25

@Composable
fun ShipmentAddressesCard(
    fromAddress: String,
    toAddress: String
) {
    Box(
        Modifier
            .padding(horizontal = largeHorizontalPadding_24, vertical = bottomPadding_20)
            .fillMaxWidth()
            .height(xLargeCardSize_188)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(end = halfWidthArc_55),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                Modifier
                    .padding(bottom = bottomPadding_32)
                    .height(largeCardSize_78)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(xLargeCornerShape_25),
                colors = CardDefaults.cardColors(containerColor = Color.Unspecified),
                border = BorderStroke(mediumBorder_2, color = borderGrayColor)
            ) {
                Row {

                    Icon(
                        painter = painterResource(id = R.drawable.map_pin),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(
                                vertical = largeVerticalPadding_24,
                                horizontal = primaryPadding
                            )
                            .size(largeIconSize_30)
                    )
                    Column(
                        Modifier
                            .padding(vertical = primaryPadding)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.from),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = fromAddress,
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }
            }
            Card(
                Modifier
                    .height(largeCardSize_78)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(xLargeCornerShape_25),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Unspecified,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                border = BorderStroke(mediumBorder_2, color = borderGrayColor)
            ) {
                Row {

                    Icon(
                        painter = painterResource(id = R.drawable.flag),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(
                                vertical = largeVerticalPadding_24,
                                horizontal = primaryPadding
                            )
                            .size(largeIconSize_30),
                    )
                    Column(
                        Modifier
                            .padding(vertical = primaryPadding)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.to),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = toAddress,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
        ArcLine(
            Modifier
                .align(Alignment.CenterEnd)
                .padding(vertical = largeArcPadding_39)
                .fillMaxHeight()
                .width(
                    widthArc_110
                )
        )
    }
}