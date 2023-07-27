package com.brave.data.di

import android.content.Context
import com.brave.data.repository.SignInRepository
import com.brave.data.repository_impl.SignInRepositoryImpl
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideSignInRepository(@ApplicationContext context: Context): SignInRepository {
        return SignInRepositoryImpl(
            auth = Firebase.auth,
            fireStore = Firebase.firestore

        )
    }


}
