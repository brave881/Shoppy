package com.brave.shoppy.screen.address

interface AddressScreenDirection {
    suspend fun back()
    suspend fun navigateToPaymentScreen()
}
