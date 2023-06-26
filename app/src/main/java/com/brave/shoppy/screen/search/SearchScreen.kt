package com.brave.shoppy.screen.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brave.shoppy.navigation.AppScreen

class SearchScreen : AppScreen() {
    @Composable
    override fun Content() {
        SearchScreenContent()
    }

    @Composable
    fun SearchScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "SearchScreen")
        }
    }
}
