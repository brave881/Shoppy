package com.brave.shoppy.di

import com.brave.shoppy.navigation.AppNavigator
import com.brave.shoppy.navigation.NavigationDispatcher
import com.brave.shoppy.navigation.NavigationHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface NavigationModule {

    @Binds
    @Singleton
    fun bindNavigationDispatcher(handler: NavigationHandler): NavigationDispatcher

    @Binds
    @Singleton
    fun bindAppNavigator(handler: NavigationHandler): AppNavigator
}
