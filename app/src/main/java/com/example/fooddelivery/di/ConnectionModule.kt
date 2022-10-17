package com.example.fooddelivery.di

import android.content.Context
import com.example.fooddelivery.utils.connection.CheckConnection
import com.example.fooddelivery.utils.connection.CheckConnectionInMoment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ConnectionModule {

    @Provides
    @Singleton
    fun provideCheckConnection(@ApplicationContext context : Context): CheckConnection {
        return CheckConnection(context = context)
    }

    @Provides
    @Singleton
    fun provideCheckConnectionInMoment(@ApplicationContext context : Context): CheckConnectionInMoment {
        return CheckConnectionInMoment(context = context)
    }
}