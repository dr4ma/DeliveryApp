package com.example.fooddelivery.domain.usecases

import com.example.fooddelivery.domain.models.retrofit.Description
import com.example.fooddelivery.domain.models.retrofit.Meal
import com.example.fooddelivery.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository, ) {

    suspend fun getCategory(category : String) : MutableList<Meal>{
        return categoryRepository.getCategory(category).body()?.meals ?: mutableListOf()
    }

    suspend fun getDescriptionOfMeal(mealId : String) : MutableList<Description>{
        return categoryRepository.getDescriptionOfMeal(mealId.toInt()).body()?.meals ?: mutableListOf()
    }
}