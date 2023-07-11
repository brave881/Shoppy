package com.brave.shoppy.screen.cart

//data class DetailsScreenState(
//    val
//)

sealed interface CartScreenEvent {
    object NavigateToAddressScreen : CartScreenEvent
    object Back : CartScreenEvent
}
