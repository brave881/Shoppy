package com.brave.shoppy.screen.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.cart.components.CartItemReview
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.MyTopAppBar
import com.brave.shoppy.utils.buttons.PrimaryBlueButton

class CartScreen : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<CartScreenViewModel>()
        CartScreenContent(viewModel::onEventDispatcher)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CartScreenContent(onEventDispatcher: (CartScreenEvent) -> Unit) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyTopAppBar(
                    title = "Cart", onClickIcon = {
                        onEventDispatcher(CartScreenEvent.Back)
                    }, modifier = Modifier.fillMaxWidth()
                )

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
                val count = listOf(
                    "1",
                    "1",
                    "1",
                    "1",
                    "1",
                )
                val image = listOf(
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                )


                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.spacing.small),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
                ) {
                    items(3) {
                        CartItemReview(image = image[it],
                            name = name[it],
                            price = price[it],
                            count = count[it],
                            onClickPlus = { /*TODO*/ },
                            onClickMinus = { /*TODO*/ },
                            onClickTrash = {})
                    }
                }
                Text(
                    modifier = Modifier.padding(bottom = MaterialTheme.spacing.small),
                    text = "*Swipe left to delete or change size",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        textAlign = TextAlign.Center
                    )
                )
                Scaffold(bottomBar = {
                    PrimaryBlueButton(
                        text = "Go to payment",
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    ) {
                        onEventDispatcher(CartScreenEvent.NavigateToAddressScreen)
                    }
                }) {

                }

                Column(
                    modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
                ) {

                }
            }
        }
    }

    @Preview
    @Composable
    fun CartScreenContentPreview() {
        ShoppyTheme {
//            CartScreenContent(viewModel::onEventDispatcher)
        }
    }
}
