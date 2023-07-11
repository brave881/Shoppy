package com.brave.shoppy.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartScreenViewModel @Inject constructor(
    private val direction: CartScreenDirection
) : ViewModel() {
    fun onEventDispatcher(event: CartScreenEvent) {
        viewModelScope.launch {
            when (event) {
                CartScreenEvent.Back -> direction.back()
                CartScreenEvent.NavigateToAddressScreen -> direction.navigateToAddressScreen()
            }
        }
    }

}
