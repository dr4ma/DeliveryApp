package com.example.fooddelivery.presentation.fragments.chickenFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.domain.models.retrofit.Description
import com.example.fooddelivery.domain.models.retrofit.ResultMealModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel
import com.example.fooddelivery.domain.usecases.CacheUseCase
import com.example.fooddelivery.domain.usecases.CategoryUseCase
import com.example.fooddelivery.utils.joinIngredientsInOne
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChickenViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val cacheUseCase: CacheUseCase
) : ViewModel() {

    val mealsList: MutableLiveData<MutableList<ResultMealModel>> = MutableLiveData()
    val cacheChickenList: MutableLiveData<MutableList<ChickenCacheModel>> = MutableLiveData()

    private var mealsListForSort: MutableList<ResultMealModel> = mutableListOf()
    private var descriptionsListForSort: MutableList<Description> = mutableListOf()
    private var cacheChickenInsertList = mutableListOf<ChickenCacheModel>()

    fun getCategory(category: String, onSuccess:() -> Unit) {
        viewModelScope.launch {
            mealsListForSort.clear()
            categoryUseCase.getCategory(category).forEach { mealModel ->
                descriptionsListForSort = categoryUseCase.getDescriptionOfMeal(mealModel.idMeal)
                val model = ResultMealModel(
                    strMeal = mealModel.strMeal,
                    strMealThumb = mealModel.strMealThumb,
                    idMeal = mealModel.idMeal,
                    ingredients = joinIngredientsInOne(descriptionsListForSort[0])
                )
                mealsListForSort.add(model)
            }
            mealsList.value = mealsListForSort
            onSuccess()

            // cache data
            cacheUseCase.deleteChicken()
            cacheChickenInsertList.clear()
            mealsListForSort.forEach {
                val model = ChickenCacheModel(
                    strMeal = it.strMeal,
                    strMealThumb = it.strMealThumb,
                    idMeal = it.idMeal,
                    ingredients = it.ingredients
                )
                cacheChickenInsertList.add(model)
            }
            cacheUseCase.insertChicken(cacheChickenInsertList)
        }
    }

    fun getCacheChicken() {
        GlobalScope.launch {
            cacheChickenList.postValue(cacheUseCase.getCacheChicken())
        }
    }
}