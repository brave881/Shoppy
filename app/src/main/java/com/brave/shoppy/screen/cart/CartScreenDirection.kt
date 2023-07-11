package com.brave.shoppy.screen.cart

interface CartScreenDirection {
    suspend fun navigateToAddressScreen()
    suspend fun back()

}
