package com.example.fooddelivery.domain.usecases

import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel
import com.example.fooddelivery.domain.repository.CacheRepository
import javax.inject.Inject

class CacheUseCase @Inject constructor(private val cacheRepository: CacheRepository) {

    suspend fun getCacheBeef() : MutableList<BeefMealCacheModel> {
        return cacheRepository.getBeef()
    }

    suspend fun getCacheChicken() : MutableList<ChickenCacheModel> {
        return cacheRepository.getChicken()
    }

    suspend fun insertBeef(meal : MutableList<BeefMealCacheModel>){
        cacheRepository.insertBeef(meal)
    }

    suspend fun insertChicken(meal : MutableList<ChickenCacheModel>){
        cacheRepository.insertChicken(meal)
    }

    suspend fun deleteBeef(){
        cacheRepository.deleteBeef()
    }

    suspend fun deleteChicken(){
        cacheRepository.deleteChicken()
    }
}