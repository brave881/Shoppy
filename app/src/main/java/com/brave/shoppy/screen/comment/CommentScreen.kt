package com.brave.shoppy.screen.comment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import com.brave.shoppy.navigation.AppScreen

class CommentScreen : AppScreen() {
    @Composable
    override fun Content() {
        CommentScreenContent()
    }

    @Composable
    fun CommentScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "CommentScreen")
        }
    }
}
