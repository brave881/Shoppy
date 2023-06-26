package com.brave.shoppy.screen.sign_in


data class SignInState(
    val isProgress: Boolean = false,
    val error: String = "",
)

sealed class SignInScreenEvent {
    data class SignIn(val email: String, val password: String) :SignInScreenEvent()
}
