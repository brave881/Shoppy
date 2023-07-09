package com.brave.shoppy.screen.settings

sealed interface SettingsScreenEvent {
    object NavigateToEditProfile : SettingsScreenEvent
    object NavigateToEditLanguage : SettingsScreenEvent
    object Back : SettingsScreenEvent
}
