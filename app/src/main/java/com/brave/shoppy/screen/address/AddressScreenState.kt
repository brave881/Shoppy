package com.brave.shoppy.screen.address

class AddressScreenState {}

sealed interface AddressScreenEvent {
    object NavigateToPaymentScreen : AddressScreenEvent
    object Back : AddressScreenEvent
}
