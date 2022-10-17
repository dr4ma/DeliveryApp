package com.example.fooddelivery.data.retrofit

import com.example.fooddelivery.domain.models.retrofit.Category
import com.example.fooddelivery.domain.models.retrofit.DescriptionList
import com.example.fooddelivery.domain.repository.CategoryRepository
import retrofit2.Response

class CategoryRequests : CategoryRepository {

    override suspend fun getCategory(category: String): Response<Category> {
        return RetrofitInstance.apiService.getCategory(category)
    }

    override suspend fun getDescriptionOfMeal(mealId: Int): Response<DescriptionList> {
        return RetrofitInstance.apiService.getDescriptionOfMeal(mealId)
    }
}