package com.brave.shoppy.screen.home

sealed interface HomeScreenEvent {
    object NavigateToDetailsScreen : HomeScreenEvent
}
