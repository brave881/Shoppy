package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.sign_in.SignInScreenDirection
import com.brave.shoppy.screen.utils.AppScreens
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class SignInScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator, private val screen: AppScreens
) : SignInScreenDirection {
    override suspend fun navigateToHomeScreen() {
        navigator.navigateToTab(screen.homeScreen())

    }

}
