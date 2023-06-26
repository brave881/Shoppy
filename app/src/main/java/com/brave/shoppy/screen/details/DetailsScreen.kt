package com.brave.shoppy.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



import com.brave.shoppy.navigation.AppScreen

class DetailsScreen : AppScreen() {
    @Composable
    override fun Content() {
        DetailsScreenContent()
    }

    @Composable
    fun DetailsScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "DetailsScreen")
        }
    }
}
