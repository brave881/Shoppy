package com.brave.data.repository

import com.brave.common.ResponseResult
import com.brave.data.model.UserData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

typealias SignInResponse = ResponseResult<Boolean>
typealias SignInState = ResponseResult<Boolean>

interface SignInRepository {
    val currentUser: FirebaseUser?
    suspend fun googleSignIn(
        email: String, password: String
    ): SignInResponse

}
