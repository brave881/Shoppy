package com.brave.shoppy.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.brave.shoppy.R
import com.brave.shoppy.screen.home.components.FloatActionButton
import com.brave.shoppy.screen.home.components.ItemCategory
import com.brave.shoppy.screen.home.components.ItemReview
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.black100
import com.brave.shoppy.ui.theme.black40
import com.brave.shoppy.ui.theme.grey100
import com.brave.shoppy.ui.theme.primary100
import com.brave.shoppy.ui.theme.white100
import com.brave.shoppy.ui.theme.white80
import com.brave.shoppy.utils.betweenItemTextPadding
import com.brave.shoppy.utils.betweenTextPadding
import com.brave.shoppy.utils.large
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.small

class HomeScreen : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(
                image = Icons.Default.Home
            )
            return remember {
                TabOptions(
                    icon = icon, title = "Home", index = 0u
                )
            }
        }

    @Composable
    override fun Content() {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()

    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.padding(
                    top = primaryPadding, start = primaryPadding, end = primaryPadding
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Good Morning ☀️",
                        fontSize = large,
                        color = black100,
                        fontFamily = FontFamily(
                            Font(R.font.nunito_extra_bold)
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search button",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(betweenTextPadding))

                Text(
                    text = "Let’s got something",
                    color = black40,
                    fontSize = small,
                    fontFamily = FontFamily(Font(R.font.nunito))
                )
            }

            Spacer(modifier = Modifier.height(betweenItemTextPadding))
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(125.dp)
                    .width(390.dp)
                    .padding(
                        start = primaryPadding, end = primaryPadding
                    ),
                colors = CardDefaults.cardColors(primary100)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Get discount up to 50%",
                        fontSize = large,
                        fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                        fontWeight = FontWeight(700),
                        color = white100
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Get a big discount with a very limited time,\n" + "what are you waiting for shop now!",
                        color = white80,
                        fontFamily = FontFamily(Font(R.font.nunito)),
                        fontSize = small,
                    )
                }
            }
            Spacer(modifier = Modifier.height(betweenItemTextPadding))

            Text(
                text = "Categories",
                fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                color = black100,
                fontSize = large,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = primaryPadding
                    )
            )
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = primaryPadding, end = primaryPadding
                    ), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemCategory(background = primary100, image = R.drawable.image_1, onClick = {})
                ItemCategory(background = grey100, image = R.drawable.pants, onClick = {})
                ItemCategory(background = grey100, image = R.drawable.image_2, onClick = {})
                ItemCategory(background = grey100, image = R.drawable.hat, onClick = {})
                ItemCategory(background = grey100, image = R.drawable.watch, onClick = {})
            }
            Spacer(modifier = Modifier.height(20.dp))
            val name = listOf(
                "Acapella Black Shirt",
                "Acapella Black Shirt",
                "Acapella Black Shirt",
                "Acapella Black Shirt",
                "Acapella Black Shirt",
            )

            val price = listOf(
                "240$",
                "240$",
                "240$",
                "240$",
                "240$",
            )
            val deprecatedPrice = listOf(
                "480$",
                "480$",
                "480$",
                "480$",
                "480$",
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(start = primaryPadding)
            ) {
                items(5) { index ->
                    ItemReview(image = R.drawable.placeholder,
                        name = name[index],
                        price = price[index],
                        deprecatedPrice = deprecatedPrice[index],
                        onClickImage = { /*TODO*/ }) {}
                }
            }
            var iconColor by remember {
                mutableStateOf(false)
            }

            Spacer(modifier = Modifier.height(15.dp))
            /*    Surface(modifier = Modifier.fillMaxWidth()) {
    //                Scaffold(bottomBar = {
    //                    BottomNavigation {
    //                        BottomSheetItem(
    //                            icon = R.drawable.home, isIconSelected = iconColor
    //                        ) {
    //                            iconColor = !iconColor
    //                        }
    //                        BottomSheetItem(
    //                            icon = R.drawable.home, isIconSelected = iconColor
    //                        ) {
    //                            iconColor = !iconColor
    //                        }
    //                        BottomSheetItem(
    //                            icon = R.drawable.home, isIconSelected = iconColor
    //                        ) {
    //                            iconColor = !iconColor
    //                        }
    //                        BottomSheetItem(
    //                            icon = R.drawable.home, isIconSelected = iconColor
    //                        ) {
    //                            iconColor = !iconColor
    //                        }
    //                    }
    //                }) {
    //                    Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
    //                }
                }*/


        }

        FloatActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(bottom = 105.dp, end = 16.dp)
                .align(alignment = Alignment.BottomEnd)
        )
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShoppyTheme() {
        HomeScreenContent()
    }
}
