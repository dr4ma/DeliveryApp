package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.models.retrofit.Category
import com.example.fooddelivery.domain.models.retrofit.DescriptionList
import retrofit2.Response

interface CategoryRepository {

    suspend fun getCategory(category: String) : Response<Category>
    suspend fun getDescriptionOfMeal(mealId: Int) : Response<DescriptionList>
}