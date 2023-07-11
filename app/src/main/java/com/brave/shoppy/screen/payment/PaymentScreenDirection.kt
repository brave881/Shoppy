package com.brave.shoppy.screen.payment

interface PaymentScreenDirection {
    suspend fun back()
    suspend fun navigateToOrderReviewScreen()
}
