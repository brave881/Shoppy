package com.brave.shoppy.screen.address

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AddressScreenViewModel @Inject constructor(
    private val direction: AddressScreenDirection
) : ViewModel() {

    fun onEventDispatcher(event: AddressScreenEvent) {
        viewModelScope.launch {
            when (event) {
                is AddressScreenEvent.NavigateToPaymentScreen -> {
                    direction.navigateToPaymentScreen()
                }

                is AddressScreenEvent.Back -> {
                    direction.back()
                }
            }
        }
    }
}
