package com.example.fooddelivery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel

@Dao
interface RoomDao {

    @Query("SELECT * FROM beef_table")
    fun getBeefMeals(): MutableList<BeefMealCacheModel>

    @Query("SELECT * FROM chicken_table")
    fun getChickenMeals(): MutableList<ChickenCacheModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBeef(characters: List<BeefMealCacheModel>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChicken(characters: List<ChickenCacheModel>)

    @Query("DELETE FROM beef_table")
    suspend fun deleteBeef()

    @Query("DELETE FROM chicken_table")
    suspend fun deleteChicken()
}