package com.example.fooddelivery.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.domain.models.room.BeefMealCacheModel

class AdapterBeefCacheDiffUtils(private val oldList : List<BeefMealCacheModel>,
                                private val newList : List<BeefMealCacheModel>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].idMeal == newList[newItemPosition].idMeal
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList == newList
    }
}