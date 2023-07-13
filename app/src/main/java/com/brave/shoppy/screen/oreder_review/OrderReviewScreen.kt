package com.brave.shoppy.screen.oreder_review

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.oreder_review.components.OrderReviewImageItem
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.MyTopAppBar
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.card.PrimaryReviewDetailCard
import com.brave.shoppy.utils.textFields.PrimaryTextField

class OrderReviewScreen : AppScreen() {
    @Composable
    override fun Content() {
        OrderReviewScreenContent()
    }

    @Composable
    fun OrderReviewScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                MyTopAppBar(title = "Order Review") {}
                var name by remember { mutableStateOf("") }
                var phoneNUmber by remember { mutableStateOf("") }
                val spacer = MaterialTheme.spacing

                PrimaryTextField(text = name,
                    title = "Name",
                    onTextChange = { name = it },
                    placeholder = {
                        Text(
                            text = "Write here",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = Color(0x661F1F24)
                            )
                        )
                    },
                    modifier = Modifier.padding(
                        start = spacer.medium, end = spacer.medium, bottom = spacer.medium
                    )
                )
                PrimaryTextField(text = phoneNUmber,
                    title = "Number phone",
                    onTextChange = { phoneNUmber = it },
                    placeholder = {
                        Text(
                            text = "Write here",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = Color(0x661F1F24)
                            )
                        )
                    },
                    modifier = Modifier.padding(
                        start = spacer.medium, end = spacer.medium, bottom = spacer.medium
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacer.medium),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Item", style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.change),
                        contentDescription = "Chjange icon button"
                    )
                }

                val listImage = listOf(
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                )

                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                        ),
                    horizontalArrangement = Arrangement.spacedBy(space = spacer.small),
                    contentPadding = PaddingValues(
                        start = spacer.medium,
                        end = spacer.medium,
                    )
                ) {
                    items(listImage.size) {
                        OrderReviewImageItem(image = listImage[it])
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacer.medium),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total", style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                        )
                    )

                    Text(
                        text = "720$", style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    )

                }


                Text(
                    text = "Payment", style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    ), modifier = Modifier.padding(spacer.medium)
                )
                PrimaryReviewDetailCard(
                    onClick = {},
                    title = "Credit Card",
                    subTitle = "3113 2003 3103 1260",
                    isAddress = false,
                    modifier = Modifier.padding(start = spacer.medium, end = spacer.medium)
                )
                Spacer(modifier = Modifier.height(spacer.small))
                Text(
                    text = "Address", style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    ), modifier = Modifier.padding(spacer.medium)
                )

                PrimaryReviewDetailCard(
                    title = "USA, New York City",
                    subTitle = "32, Hancock St",
                    isAddress = true,
                    onClick = {},
                    modifier = Modifier.padding(start = spacer.medium, end = spacer.medium)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(MaterialTheme.size.mapCardItemHeight)
                        .padding(spacer.medium), shape = MaterialTheme.shapes.extraLarge
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = spacer.medium,
                                    end = spacer.medium,
                                    top = spacer.medium,
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total", style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                                )
                            )
                            Text(
                                text = "720$", style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                                )
                            )
                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(spacer.medium),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Shipping",
                                style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                                )
                            )
                            Text(
                                text = "10$", style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                                )
                            )
                        }
                    }

                }

                PrimaryBlueButton(
                    text = "Buy now - $730", modifier = Modifier.padding(spacer.medium)
                ) {

                }

            }
        }
    }


    @Preview
    @Composable
    fun OrderReviewScreenContentPreview() {
        ShoppyTheme() {
            OrderReviewScreenContent()
        }
    }
}
