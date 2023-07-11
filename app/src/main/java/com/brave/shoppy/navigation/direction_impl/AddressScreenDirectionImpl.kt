package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.address.AddressScreenDirection
import com.brave.shoppy.screen.payment.utils.utils.AppScreens
import javax.inject.Inject

class AddressScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator, private val screen: AppScreens
) : AddressScreenDirection {
    override suspend fun back() {
        navigator.back()
    }

    override suspend fun navigateToPaymentScreen() {
        navigator.navigateTo(screen.paymentScreen())
    }
}
