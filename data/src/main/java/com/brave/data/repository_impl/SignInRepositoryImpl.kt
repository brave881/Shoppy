package com.brave.data.repository_impl

import com.brave.common.ResponseResult
import com.brave.data.repository.SignInRepository
import com.brave.data.repository.SignInResponse
import com.brave.data.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


internal class SignInRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth, private val fireStore: FirebaseFirestore
) : SignInRepository {
    override val currentUser: FirebaseUser?
        get() = auth.currentUser

    override suspend fun googleSignIn(email: String, password: String): SignInResponse {
        return try {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                val map = HashMap<String, String>()
                map[email] = password
                fireStore.collection(Constants.USERS).document(email).set(map)
                runBlocking { ResponseResult.Success(data = true) }
            }.await()
            ResponseResult.Success(data = true)
        } catch (e: Exception) {
            ResponseResult.Error(message = e.message.toString())
        }
    }
}
