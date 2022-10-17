package com.example.fooddelivery.data.retrofit

import com.example.fooddelivery.domain.models.retrofit.Category
import com.example.fooddelivery.domain.models.retrofit.DescriptionList
import com.example.fooddelivery.utils.FILTER_URL
import com.example.fooddelivery.utils.LOOKUP_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(FILTER_URL)
    suspend fun getCategory(@Query("c") category : String): Response<Category>

    @GET(LOOKUP_URL)
    suspend fun getDescriptionOfMeal(@Query("i") mealId : Int): Response<DescriptionList>
}