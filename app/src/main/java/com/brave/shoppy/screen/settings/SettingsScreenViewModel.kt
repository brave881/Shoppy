package com.brave.shoppy.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val direction: SettingsScreenDirection
) : ViewModel() {

    fun onEventDispatcher(event: SettingsScreenEvent) {
        viewModelScope.launch {
            when (event) {
                SettingsScreenEvent.Back -> { viewModelScope.launch { direction.back() } }
                SettingsScreenEvent.NavigateToEditLanguage -> { viewModelScope.launch { direction.navigateToEditLanguage() } }
                SettingsScreenEvent.NavigateToEditProfile -> { viewModelScope.launch { direction.navigateToEditProfile() } }
            }
        }
    }
}
