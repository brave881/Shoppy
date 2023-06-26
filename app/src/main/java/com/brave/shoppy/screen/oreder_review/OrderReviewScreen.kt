package com.brave.shoppy.screen.oreder_review

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class OrderReviewScreen : AppScreen() {
    @Composable
    override fun Content() {
        OrderReviewScreenContent()
    }

    @Composable
    fun OrderReviewScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "OrderReviewScreen")
        }
    }
}
