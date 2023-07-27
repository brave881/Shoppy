package com.brave.shoppy.screen.bag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class BagScreenViewModel @Inject constructor(
    private val direction: BagScreenDirection
) : ViewModel() {
    fun onEventDispatcher(event: BagScreenEvent) {
        viewModelScope.launch {
            when (event) {
                BagScreenEvent.NavigateToShipmentScreen -> {
                    direction.navigateToShipmentScreen()
                }
                BagScreenEvent.Back -> {
                    direction.back()
                }
            }
        }
    }
}
