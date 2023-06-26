package com.brave.shoppy.screen.favourite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class FavouriteScreen : AppScreen() {
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
