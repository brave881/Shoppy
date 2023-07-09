package com.brave.shoppy.screen.settings

interface SettingsScreenDirection {
    suspend fun navigateToEditProfile()
    suspend fun navigateToEditLanguage()
    suspend fun back()
}
