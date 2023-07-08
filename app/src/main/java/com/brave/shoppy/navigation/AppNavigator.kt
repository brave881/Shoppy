package com.brave.shoppy.navigation

import cafe.adriel.voyager.core.screen.Screen

interface AppNavigator {
    suspend fun navigateTo(screen: AppScreen)
    suspend fun navigateToTab(screen: Screen)
    suspend fun navigateTo(screen: List<AppScreen>)
    suspend fun replace(screen: AppScreen)
    suspend fun replaceAll(screen: List<AppScreen>)
    suspend fun replaceTo(screen: AppScreen)
    suspend fun <T : AppScreen> backUntil(clazz: Class<T>)
    suspend fun back()

}
