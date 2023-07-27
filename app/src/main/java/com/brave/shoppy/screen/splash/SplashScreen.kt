package com.brave.shoppy.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen

class SplashScreen : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<SplashScreenViewModel>()
        SplashScreenContent()
    }

    @Composable
    private fun SplashScreenContent() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
        }
    }

}
