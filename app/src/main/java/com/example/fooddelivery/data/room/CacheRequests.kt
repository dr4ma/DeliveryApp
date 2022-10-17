package com.example.fooddelivery.data.room

import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel
import com.example.fooddelivery.domain.repository.CacheRepository
import javax.inject.Inject

class CacheRequests @Inject constructor(private val roomDao : RoomDao) : CacheRepository {

    override suspend fun getBeef(): MutableList<BeefMealCacheModel> {
        return roomDao.getBeefMeals()
    }

    override suspend fun getChicken(): MutableList<ChickenCacheModel> {
        return roomDao.getChickenMeals()
    }

    override suspend fun insertBeef(meal: List<BeefMealCacheModel>) {
        roomDao.insertBeef(meal)
    }

    override suspend fun insertChicken(meal: List<ChickenCacheModel>) {
        roomDao.insertChicken(meal)
    }

    override suspend fun deleteBeef() {
        roomDao.deleteBeef()
    }

    override suspend fun deleteChicken() {
        roomDao.deleteChicken()
    }
}