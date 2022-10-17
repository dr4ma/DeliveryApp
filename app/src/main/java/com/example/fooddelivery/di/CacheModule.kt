package com.example.fooddelivery.di

import android.app.Application
import com.example.fooddelivery.data.room.CacheRequests
import com.example.fooddelivery.data.room.RoomDao
import com.example.fooddelivery.data.room.RoomDatabase
import com.example.fooddelivery.domain.repository.CacheRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(context: Application): RoomDatabase {
        return RoomDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDao(roomDatabase: RoomDatabase): RoomDao {
        return roomDatabase.getRoomDao()
    }

    @Singleton
    @Provides
    fun provideRoomRepo(dao: RoomDao) : CacheRepository{
        return CacheRequests(dao)
    }
}