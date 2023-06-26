package com.brave.shoppy.navigation

import kotlinx.coroutines.flow.MutableSharedFlow

interface NavigationDispatcher {
    val navigationArgs: MutableSharedFlow<NavigationArgs>
}
