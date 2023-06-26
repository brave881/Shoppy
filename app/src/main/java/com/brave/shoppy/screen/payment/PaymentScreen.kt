package com.brave.shoppy.screen.payment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class PaymentScreen : AppScreen() {
    @Composable
    override fun Content() {
        PaymentScreenContent()
    }

    @Composable
    fun PaymentScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Payment")
        }
    }
}
