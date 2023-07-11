package com.brave.shoppy.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModelImpl @Inject constructor(
    private val detailsScreenDirection: DetailsScreenDirection
) : ViewModel() {
    fun onEventDispatcher(event: DetailsScreenEvent) {
        viewModelScope.launch {
            when (event) {
                DetailsScreenEvent.Back -> detailsScreenDirection.back()
                DetailsScreenEvent.NavigateToCartScreen -> detailsScreenDirection.navigateToCartScreen()
            }
        }
    }

}
