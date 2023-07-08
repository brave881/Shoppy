package com.brave.shoppy.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.black100
import com.brave.shoppy.ui.theme.black40
import com.brave.shoppy.ui.theme.white100
import com.brave.shoppy.utils.medium
import com.brave.shoppy.utils.small

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
            .height(400.dp)
            .width(200.dp)
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(280.dp)
                .padding(bottom = 8.dp),
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

        Text(
            text = name,
            fontSize = medium,
            color = black100,
            fontFamily = FontFamily(Font(R.font.nunito)),
            fontWeight = FontWeight(600)
        )
        Spacer(modifier = Modifier.height(10.dp))


        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = price,
                fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                fontSize = medium,
                color = black100
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = deprecatedPrice,
                color = black40,
                fontFamily = FontFamily(Font(R.font.nunito)),
                textDecoration = TextDecoration.LineThrough,
                fontSize = small
            )
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
        colors = CardDefaults.cardColors(white100),
        shape = RoundedCornerShape(18.dp)
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
