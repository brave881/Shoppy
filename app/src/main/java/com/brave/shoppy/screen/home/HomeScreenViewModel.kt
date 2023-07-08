package com.brave.shoppy.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val direction: HomeScreenDirection
) : ViewModel() {

    fun onEventDispatcher(event: HomeScreenEvent) {
        viewModelScope.launch {
            when (event) {
                HomeScreenEvent.NavigateToDetailsScreen -> direction.navigateToDetailScreen()
            }
        }
    }
}
