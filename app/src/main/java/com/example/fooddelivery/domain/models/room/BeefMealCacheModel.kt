package com.example.fooddelivery.domain.models.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beef_table")
data class BeefMealCacheModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo var strMeal : String = "",
    @ColumnInfo var strMealThumb : String = "",
    @ColumnInfo var idMeal : String = "",
    @ColumnInfo var ingredients : String = ""
)
