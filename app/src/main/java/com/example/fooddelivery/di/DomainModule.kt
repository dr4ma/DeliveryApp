package com.example.fooddelivery.di

import com.example.fooddelivery.domain.repository.CacheRepository
import com.example.fooddelivery.domain.repository.CategoryRepository
import com.example.fooddelivery.domain.usecases.CacheUseCase
import com.example.fooddelivery.domain.usecases.CategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideCategoryUseCase(repository: CategoryRepository): CategoryUseCase{
        return CategoryUseCase(categoryRepository = repository)
    }

    @Provides
    fun provideCacheUseCase(repository: CacheRepository): CacheUseCase{
        return CacheUseCase(cacheRepository = repository)
    }
}