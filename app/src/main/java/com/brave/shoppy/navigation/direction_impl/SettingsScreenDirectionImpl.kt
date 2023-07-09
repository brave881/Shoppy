package com.brave.shoppy.navigation.direction_impl

import android.util.Log
import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.home.HomeScreenDirection
import com.brave.shoppy.screen.settings.SettingsScreenDirection
import com.brave.shoppy.screen.utils.AppScreens
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class SettingsScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator,
    private val screens: AppScreens
) : SettingsScreenDirection {

    override suspend fun navigateToEditProfile() {
        navigator.navigateTo(screens.editProfileScreen())
    }

    override suspend fun navigateToEditLanguage() {
        navigator.navigateTo(screens.editLanguage())
    }

    override suspend fun back() {
        navigator.back()
    }

}
