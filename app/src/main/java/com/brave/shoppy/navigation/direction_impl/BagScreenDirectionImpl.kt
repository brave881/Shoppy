package com.brave.shoppy.navigation.direction_impl

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.screen.bag.BagScreenDirection
import com.brave.shoppy.screen.payment.utils.utils.AppScreens
import javax.inject.Inject

class BagScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigator,
    private val screen: AppScreens
) : BagScreenDirection {
    override suspend fun back() {
        navigator.back()
    }

    override suspend fun navigateToShipmentScreen() {
        navigator.navigateTo(screen.shipmentScreen())
    }
}
