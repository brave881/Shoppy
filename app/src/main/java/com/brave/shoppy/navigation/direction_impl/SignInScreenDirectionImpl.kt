package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.sign_in.SignInScreenDirection
import com.brave.shoppy.screen.utils.AppScreens
import javax.inject.Inject

class SignInScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator, private val screen: AppScreens
) : SignInScreenDirection {
    override suspend fun navigateToHomeScreen() {
//        navigator.navigateTo(screen.homeScreen())
    }
}
