package com.brave.shoppy.screen.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class SettingsScreen : AppScreen() {
    @Composable
    override fun Content() {
        SettingsScreenContent()
    }

    @Composable
    private fun SettingsScreenContent() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "SettingsScreen")
        }
    }
}
