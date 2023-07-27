package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.payment.utils.utils.AppScreens
import com.brave.shoppy.screen.splash.SplashScreenDirection
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator, private val screens: AppScreens
) : SplashScreenDirection {
    override suspend fun navigateToHomeScreen() {
        navigator.navigateToTab(screens.homeScreen())
    }

    override suspend fun navigateToSignInScreen() {
        navigator.navigateTo(screens.signInScreen())
    }
}
