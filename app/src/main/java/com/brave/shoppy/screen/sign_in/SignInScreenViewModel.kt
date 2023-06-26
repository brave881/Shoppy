package com.brave.shoppy.screen.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInScreenViewModel @Inject constructor(
    private val signInScreenDirection: SignInScreenDirection
) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInScreenEvent) {
        viewModelScope.launch {
            when (event) {
                is SignInScreenEvent.SignIn -> {
                    signInScreenDirection.navigateToHomeScreen()
                }
            }
        }
    }

}
