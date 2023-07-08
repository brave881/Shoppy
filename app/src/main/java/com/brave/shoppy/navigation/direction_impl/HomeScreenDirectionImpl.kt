package com.brave.shoppy.navigation.direction_impl

import android.util.Log
import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.home.HomeScreenDirection
import com.brave.shoppy.screen.utils.AppScreens
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class HomeScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator,
    private val screens: AppScreens
) : HomeScreenDirection {
    override suspend fun navigateToDetailScreen() {
        navigator.navigateTo(screens.detailsScreen())
        Log.d("HomeScreenDirectionImpl", "navigateToDetailScreen:   navigator.replace(screens.detailsScreen())")
    }
}
