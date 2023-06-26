package com.brave.shoppy.screen.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class CartScreen : AppScreen() {
    @Composable
    override fun Content() {
        CartScreenContent()
    }

    @Composable
    fun CartScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
           Text(text = "CartScreen")
        }
    }
}
