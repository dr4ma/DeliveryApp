package com.example.fooddelivery.di

import com.example.fooddelivery.presentation.fragments.beefFragment.BeefAdapter
import com.example.fooddelivery.presentation.fragments.beefFragment.BeefCacheAdapter
import com.example.fooddelivery.presentation.fragments.chickenFragment.ChickenAdapter
import com.example.fooddelivery.presentation.fragments.chickenFragment.ChickenCacheAdapter
import com.example.fooddelivery.presentation.fragments.menuFragment.MenuAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdaptersModule {

    @Provides
    @Singleton
    fun provideOffersAdapter(): MenuAdapter {
        return MenuAdapter()
    }

    @Provides
    @Singleton
    fun provideBeefAdapter(): BeefAdapter {
        return BeefAdapter()
    }

    @Provides
    @Singleton
    fun provideBeefCacheAdapter(): BeefCacheAdapter {
        return BeefCacheAdapter()
    }

    @Provides
    @Singleton
    fun provideChickenAdapter(): ChickenAdapter {
        return ChickenAdapter()
    }

    @Provides
    @Singleton
    fun provideChickenCacheAdapter(): ChickenCacheAdapter {
        return ChickenCacheAdapter()
    }
}