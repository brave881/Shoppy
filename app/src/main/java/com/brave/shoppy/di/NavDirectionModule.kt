package com.brave.shoppy.di

import com.brave.shoppy.navigation.direction_impl.HomeScreenDirectionImpl
import com.brave.shoppy.navigation.direction_impl.SettingsScreenDirectionImpl
import com.brave.shoppy.navigation.direction_impl.SignInScreenDirectionImpl
import com.brave.shoppy.screen.home.HomeScreenDirection
import com.brave.shoppy.screen.settings.SettingsScreenDirection
import com.brave.shoppy.screen.sign_in.SignInScreenDirection
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavDirectionModule {


    @Binds
    fun bindSignInDirection(impl: SignInScreenDirectionImpl): SignInScreenDirection

    @Binds
    fun bindHomeDirection(impl: HomeScreenDirectionImpl): HomeScreenDirection

    @Binds
    fun bindSettingsDirection(impl: SettingsScreenDirectionImpl): SettingsScreenDirection
}
