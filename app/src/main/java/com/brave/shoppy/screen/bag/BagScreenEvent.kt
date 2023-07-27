package com.brave.shoppy.screen.bag

sealed interface BagScreenEvent {
    object Back : BagScreenEvent
    object NavigateToShipmentScreen : BagScreenEvent
}
