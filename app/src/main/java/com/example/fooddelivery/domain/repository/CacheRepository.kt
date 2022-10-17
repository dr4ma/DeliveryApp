package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel

interface CacheRepository {

    suspend fun getBeef() : MutableList<BeefMealCacheModel>
    suspend fun getChicken(): MutableList<ChickenCacheModel>

    suspend fun insertBeef(meal:List<BeefMealCacheModel>)
    suspend fun insertChicken(meal:List<ChickenCacheModel>)

    suspend fun deleteBeef()
    suspend fun deleteChicken()
}