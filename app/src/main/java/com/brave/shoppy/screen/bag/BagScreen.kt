package com.brave.shoppy.screen.bag

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class BagScreen : AppScreen() {
    @Composable
    override fun Content() {
        BagScreenContent()
    }

    @Composable
    fun BagScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text ="Bag Screen")
        }
    }
}