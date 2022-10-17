package com.example.fooddelivery.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.domain.models.room.ChickenCacheModel

class AdapterChickenCacheDiffUtils(private val oldList : List<ChickenCacheModel>,
                                   private val newList : List<ChickenCacheModel>) : DiffUtil.Callback() {

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