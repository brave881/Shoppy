package com.brave.shoppy.screen.favourite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class FavouriteScreen : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(image = Icons.Default.Favorite)
            return remember {
                TabOptions(
                    index = 2u, icon = icon, title = ""
                )
            }
        }

    @Composable
    override fun Content() {
        FavouriteScreenContent()
    }

    @Composable
    fun FavouriteScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "FavouriteScreen")
        }
    }
}
