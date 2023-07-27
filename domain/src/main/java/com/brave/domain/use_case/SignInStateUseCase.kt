package com.brave.domain.use_case

import com.brave.data.repository.SignInRepository
import javax.inject.Inject

class SignInStateUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    suspend operator fun invoke() = repository.currentUser
}
