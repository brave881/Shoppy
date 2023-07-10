package com.brave.shoppy.screen.details


import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.details.utils.SizeLetters
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.MyTopAppBar
import com.brave.shoppy.utils.card.PrimaryImageButton
import com.brave.shoppy.utils.buttons.PrimaryTextButton

class DetailsScreen : AppScreen() {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<DetailsScreenViewModelImpl>()
        viewModel.addCloseable {}
        DetailsScreenContent()
        Log.d("DetailsScreen", "Content: ")
    }

    @Composable
    fun DetailsScreenContent() {
        var favIconState by remember {
            mutableStateOf(false)
        }
        val spacer = MaterialTheme.spacing
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    MyTopAppBar(title = "Items", onClickIcon = {})
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = spacer.medium, end = spacer.medium),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                space = MaterialTheme.spacing.small
                            )
                        ) {
                            Text(
                                text = "Acapella White Shirt",
                                style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(
                                        Font(R.font.nunito_semi_bold)
                                    )
                                )
                            )
                            Row(horizontalArrangement = Arrangement.Center) {
                                Text(
                                    text = "240$",
                                    style = MaterialTheme.typography.displaySmall.copy(
                                        fontFamily = FontFamily(
                                            Font(R.font.nunito_bold)
                                        )
                                    ),
                                    modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                                )
                                Text(
                                    text = "480$",
                                    style = MaterialTheme.typography.headlineMedium.copy(
                                        textDecoration = TextDecoration.LineThrough
                                    )
                                )
                            }
                        }

                        PrimaryImageButton(image = if (favIconState) R.drawable.heart_fill
                        else R.drawable.heart, onClick = {
                            favIconState = !favIconState
                        })
                    }

                    Spacer(modifier = Modifier.height(spacer.large))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.placeholder),
                            contentDescription = "Image item",
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.8f)
                                .clip(
                                    shape = MaterialTheme.shapes.medium.copy(
                                        topStart = CornerSize(0.dp),
                                        topEnd = CornerSize(10.dp),
                                        bottomEnd = CornerSize(0.dp),
                                        bottomStart = CornerSize(0.dp)
                                    )
                                ),
                            contentScale = ContentScale.FillBounds
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.2f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(spacer.small)
                        ) {
                            Text(
                                text = "Size", style = MaterialTheme.typography.headlineMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                                )
                            )
                            var state by remember {
                                mutableStateOf(SizeLetters.DEFAULT)
                            }
                            PrimaryTextButton(
                                letter = "M",
                                onClick = { state = SizeLetters.M },
                                onSelected = state == SizeLetters.M
                            )
                            PrimaryTextButton(
                                letter = "S",
                                onClick = { state = SizeLetters.S },
                                onSelected = state == SizeLetters.S
                            )
                            PrimaryTextButton(
                                letter = "L",
                                onClick = { state = SizeLetters.L },
                                onSelected = state == SizeLetters.L
                            )
                            PrimaryTextButton(
                                letter = "XL",
                                onClick = { state = SizeLetters.XL },
                                onSelected = state == SizeLetters.XL
                            )

                            Spacer(modifier = Modifier.height(spacer.medium))
                            PrimaryImageButton(
                                image = R.drawable.message,
                                onClick = { /*TODO*/ },
                                backgroundColor = MaterialTheme.colorScheme.secondary
                            )
                            PrimaryImageButton(
                                image = R.drawable.shopping_cart,
                                onClick = { /*TODO*/ },
                                backgroundColor = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }


    }


    @Preview(backgroundColor = 0xFFFFFFFF, showSystemUi = true, showBackground = true)
    @Composable
    fun DetailsScreenContentPreview() {
        ShoppyTheme() {
            DetailsScreenContent()
        }
    }
}
