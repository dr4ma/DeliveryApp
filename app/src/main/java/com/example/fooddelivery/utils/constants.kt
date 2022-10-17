package com.example.fooddelivery.utils

import com.example.fooddelivery.presentation.activity.MainActivity

lateinit var APP_ACTIVITY_MAIN: MainActivity

var CONNECTED : Boolean = false

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
const val FILTER_URL = "filter.php"
const val LOOKUP_URL = "lookup.php"
const val BEEF_CATEGORY = "Beef"
const val CHICKEN_CATEGORY = "Chicken"