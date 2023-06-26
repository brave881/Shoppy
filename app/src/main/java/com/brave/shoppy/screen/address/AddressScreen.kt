package com.brave.shoppy.screen.address

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class AddressScreen : AppScreen() {
    @Composable
    override fun Content() {
        AddressScreenContent()
    }

    @Composable
    fun AddressScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text("AddressScreen")
        }
    }
}
