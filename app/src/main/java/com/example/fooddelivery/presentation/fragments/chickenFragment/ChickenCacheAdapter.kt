package com.example.fooddelivery.presentation.fragments.chickenFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.ItemMenuRecyclerBinding
import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN
import com.example.fooddelivery.utils.CONNECTED
import com.example.fooddelivery.utils.diffUtils.AdapterBeefCacheDiffUtils
import com.example.fooddelivery.utils.diffUtils.AdapterChickenCacheDiffUtils
import com.example.fooddelivery.utils.diffUtils.AdapterMenuDiffUtils
import com.example.fooddelivery.utils.downloadIcon

class ChickenCacheAdapter : RecyclerView.Adapter<ChickenCacheAdapter.MenuViewHolder>() {

    private var listMeals = mutableListOf<ChickenCacheModel>()

    inner class MenuViewHolder(private val binding: ItemMenuRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: ChickenCacheModel) {
            with(binding) {
                nameFood.text = meal.strMeal
                ingredientsFood.text = meal.ingredients
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChickenCacheAdapter.MenuViewHolder {
        val binding =
            ItemMenuRecyclerBinding.inflate(LayoutInflater.from(APP_ACTIVITY_MAIN), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChickenCacheAdapter.MenuViewHolder, position: Int) {
        holder.bind(listMeals[position])
    }

    override fun getItemCount(): Int {
        return listMeals.size
    }

    fun setData(newList: MutableList<ChickenCacheModel>) {
        val diffUtil = AdapterChickenCacheDiffUtils(listMeals, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        listMeals.clear()
        listMeals.addAll(newList)
        diffResults.dispatchUpdatesTo(this)
    }

}