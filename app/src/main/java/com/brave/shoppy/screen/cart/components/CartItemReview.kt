package com.brave.shoppy.screen.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.size
import com.brave.shoppy.ui.theme.spacing

@Composable
fun CartItemReview(
    modifier: Modifier = Modifier,
    image: Int,
    name: String,
    price: String,
    count: String,
    onClickPlus: () -> Unit,
    onClickMinus: () -> Unit,
    onClickTrash: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small,
            )
            .height(MaterialTheme.size.cartItemReviewHeight)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(), shape = MaterialTheme.shapes.extraSmall
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = MaterialTheme.spacing.small,
                        end = MaterialTheme.spacing.small,
                        bottom = MaterialTheme.spacing.small
                    ),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
//                        .padding(MaterialTheme.spacing.small)
                        .weight(0.4f)
                        .clip(shape = MaterialTheme.shapes.small),
                )
                Column(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxHeight()
                        .padding(start = MaterialTheme.spacing.small),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
//                    Surface() {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
                    ) {
                        Text(
                            text = name, style = MaterialTheme.typography.displaySmall.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                            )
                        )
                        Text(
                            text = price, style = MaterialTheme.typography.displaySmall.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_bold))
                            )
                        )
                    }
//                    }

                    Row(
                        modifier = Modifier.padding(start = MaterialTheme.spacing.extraXLarge),
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        CartItemReviewButton(
                            onClick = onClickMinus,
                            color = MaterialTheme.colorScheme.onPrimary,
                            icon = R.drawable.minus,
                            colorTint = Color.Black
                        )
                        Text(
                            text = count, style = MaterialTheme.typography.displayMedium.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_semi_bold)),
                            )
                        )
                        CartItemReviewButton(
                            onClick = onClickPlus,
                            color = MaterialTheme.colorScheme.primary,
                            icon = R.drawable.plus,
                            colorTint = Color.White
                        )
                        CartItemReviewButton(
                            onClick = onClickTrash,
                            color = Color(0x99F87C7C),
                            icon = R.drawable.trash,
                            colorTint = Color.Red
                        )

                    }


                }
            }

        }
    }
}
