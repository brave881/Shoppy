package com.brave.domain.use_case

import com.brave.data.repository.SignInRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    suspend operator fun invoke(email: String, password: String) =
        repository.googleSignIn(email, password)
}
