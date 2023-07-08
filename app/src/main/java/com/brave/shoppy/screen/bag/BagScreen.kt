package com.brave.shoppy.screen.bag

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class BagScreen : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(image = Icons.Default.ShoppingCart)
            return remember {
                TabOptions(
                    index = 1u, title = "", icon
                )
            }
        }

    @Composable
    override fun Content() {
        BagScreenContent()
    }

    @Composable
    fun BagScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Bag Screen")
        }
    }
}
