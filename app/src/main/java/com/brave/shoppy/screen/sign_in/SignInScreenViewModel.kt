package com.brave.shoppy.screen.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brave.domain.use_case.SignInWithGoogleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

val TAG = "brave"

@HiltViewModel
class SignInScreenViewModel @Inject constructor(
    private val direction: SignInScreenDirection,
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInScreenEvent) {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            when (event) {
                is SignInScreenEvent.SignIn -> {
                    if (signInWithGoogleUseCase(event.email, event.password).data == true) {
                        _state.value = _state.value.copy(
                            success = true, loading = false
                        )
                        direction.navigateToHomeScreen()
                    } else {
                        _state.value = _state.value.copy(
                            error = "Fail!!", loading = false
                        )
                    }

                }

            }
        }
    }

}
