package com.brave.shoppy.screen.bag

interface BagScreenDirection {
    suspend fun back()
    suspend fun navigateToShipmentScreen()
}
