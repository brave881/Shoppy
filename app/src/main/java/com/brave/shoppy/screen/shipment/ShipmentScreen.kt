package com.brave.shoppy.screen.shipment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen


class ShipmentScreen : AppScreen() {
    @Composable
    override fun Content() {
        ShipmentScreenContent()
    }

    @Composable
    private fun ShipmentScreenContent() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "ShipmentScreen")
        }
    }
}
