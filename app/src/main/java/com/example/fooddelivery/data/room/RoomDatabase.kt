package com.example.fooddelivery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel

@Database(entities = [BeefMealCacheModel::class, ChickenCacheModel::class], version = 1, exportSchema = false)
abstract class RoomDatabase : androidx.room.RoomDatabase() {

    abstract fun getRoomDao() : RoomDao

    companion object {

        @Volatile
        private var database: RoomDatabase? = null

        fun getInstance(context: Context): RoomDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    RoomDatabase::class.java,
                    "database"
                ).build()
                return database as RoomDatabase
            } else {
                return database as RoomDatabase
            }
        }
    }
}