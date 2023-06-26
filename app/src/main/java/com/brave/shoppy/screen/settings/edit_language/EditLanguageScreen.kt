package com.brave.shoppy.screen.settings.edit_language

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class EditLanguageScreen : AppScreen() {
    @Composable
    override fun Content() {
        EditLanguageScreenContent()
    }

    @Composable
    private fun EditLanguageScreenContent() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "ShipmentScreen")
        }
    }
}
