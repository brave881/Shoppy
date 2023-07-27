package com.brave.shoppy.screen.sign_in

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


data class SignInState(
    val success: Boolean = false, val loading: Boolean = false, val error: String = ""
)

sealed class SignInScreenEvent {

    data class SignIn(val email: String, val password: String) : SignInScreenEvent()

}
