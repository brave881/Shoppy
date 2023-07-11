package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.cart.CartScreenDirection
import com.brave.shoppy.screen.payment.utils.utils.AppScreens
import javax.inject.Inject

class CartScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator, private val screen: AppScreens
) : CartScreenDirection {
    override suspend fun navigateToAddressScreen() {
        navigator.navigateTo(screen = screen.addressScreen())
    }

    override suspend fun back() {
        navigator.back()
    }
}
