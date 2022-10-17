package com.example.fooddelivery.presentation.fragments.beefFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.ItemMenuRecyclerBinding
import com.example.fooddelivery.domain.models.retrofit.ResultMealModel
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN
import com.example.fooddelivery.utils.diffUtils.AdapterMenuDiffUtils
import com.example.fooddelivery.utils.downloadIcon

class BeefAdapter : RecyclerView.Adapter<BeefAdapter.MenuViewHolder>() {

    private var listMeals = mutableListOf<ResultMealModel>()

    inner class MenuViewHolder(private val binding: ItemMenuRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: ResultMealModel) {
            with(binding) {
                nameFood.text = meal.strMeal
                imageFood.downloadIcon(meal.strMealThumb)
                ingredientsFood.text = meal.ingredients
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuRecyclerBinding.inflate(LayoutInflater.from(APP_ACTIVITY_MAIN), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(listMeals[position])
    }

    override fun getItemCount(): Int {
        return listMeals.size
    }

    fun setData(newList: MutableList<ResultMealModel>) {
        val diffUtil = AdapterMenuDiffUtils(listMeals, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        listMeals.clear()
        listMeals.addAll(newList)
        diffResults.dispatchUpdatesTo(this)
    }
}