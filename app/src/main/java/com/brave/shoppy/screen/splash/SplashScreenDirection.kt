package com.brave.shoppy.screen.splash

interface SplashScreenDirection {
    suspend fun navigateToHomeScreen()
    suspend fun navigateToSignInScreen()
}
