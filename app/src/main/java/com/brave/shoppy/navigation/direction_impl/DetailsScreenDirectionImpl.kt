package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.details.DetailsScreenDirection
import com.brave.shoppy.screen.payment.utils.utils.AppScreens
import javax.inject.Inject

class DetailsScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator,
    private val screen: AppScreens,
) : DetailsScreenDirection {

    override suspend fun navigateToCartScreen() {
       navigator.navigateTo(screen = screen.cartScreen())
    }

    override suspend fun back() {
        navigator.back()
    }

}
