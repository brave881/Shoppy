package com.brave.shoppy.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModelImpl @Inject constructor(
//    val detailsScreenDirection: DetailsScreenDirectionImpl
) : ViewModel() {
    fun onEvent() {
        viewModelScope.launch {

        }
    }

}
