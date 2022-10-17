package com.example.fooddelivery.di

import com.example.fooddelivery.data.retrofit.CategoryRequests
import com.example.fooddelivery.data.room.CacheRequests
import com.example.fooddelivery.domain.repository.CacheRepository
import com.example.fooddelivery.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideCategoryRequests() : CategoryRepository{
        return CategoryRequests()
    }
}