package com.brave.shoppy.screen.details

//data class DetailsScreenState(
//    val
//)

sealed interface DetailsScreenEvent {
    object NavigateToCartScreen : DetailsScreenEvent
    object Back : DetailsScreenEvent
}
