package com.brave.shoppy.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R

@Composable
fun ItemReview(
    image: Int,
    name: String,
    price: String,
    deprecatedPrice: String,
    modifier: Modifier = Modifier,
    onClickImage: () -> Unit,
    onClickFavButton: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxHeight(0.6f)
                .width(200.dp),
            shape = RoundedCornerShape(20.dp),
        ) {
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .align(Alignment.End)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Image review",
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onClickImage() },
                    contentScale = ContentScale.FillHeight
                )
                FavButton(onClickFavButton)
            }
        }
        Column(modifier = Modifier.fillMaxHeight(0.4f)) {
            Text(
                text = name,
                fontSize = medium,
                fontFamily = FontFamily(Font(R.font.nunito)),
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(10.dp))


            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = price,
                    fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                    fontSize = medium,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = deprecatedPrice,
                    fontFamily = FontFamily(Font(R.font.nunito)),
                    textDecoration = TextDecoration.LineThrough,
                    fontSize = small
                )
            }

        }

    }
}

@Composable
fun FavButton(onClickFavButton: () -> Unit) {
    Card(
        modifier = Modifier
            .height(48.dp)
            .width(48.dp)
            .padding(top = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClickFavButton() }) {
            Image(
                painter = painterResource(id = R.drawable.heart_fill),
                contentDescription = "Icon heart filled",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}
