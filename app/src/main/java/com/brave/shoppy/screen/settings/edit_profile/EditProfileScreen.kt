package com.brave.shoppy.screen.settings.edit_profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen


class EditProfileScreen : AppScreen() {
    @Composable
    override fun Content() {
        EditProfileScreenContent()
    }

    @Composable
    private fun EditProfileScreenContent() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "EditProfileScreen")
        }
    }
}
