package com.example.fooddelivery.presentation.fragments.beefFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.ItemMenuRecyclerBinding
import com.example.fooddelivery.domain.models.room.BeefMealCacheModel
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN
import com.example.fooddelivery.utils.CONNECTED
import com.example.fooddelivery.utils.diffUtils.AdapterBeefCacheDiffUtils
import com.example.fooddelivery.utils.diffUtils.AdapterMenuDiffUtils
import com.example.fooddelivery.utils.downloadIcon

class BeefCacheAdapter : RecyclerView.Adapter<BeefCacheAdapter.MenuViewHolder>() {

    private var listMeals = mutableListOf<BeefMealCacheModel>()

    inner class MenuViewHolder(private val binding: ItemMenuRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: BeefMealCacheModel) {
            with(binding) {
                nameFood.text = meal.strMeal
                ingredientsFood.text = meal.ingredients
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeefCacheAdapter.MenuViewHolder {
        val binding =
            ItemMenuRecyclerBinding.inflate(LayoutInflater.from(APP_ACTIVITY_MAIN), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeefCacheAdapter.MenuViewHolder, position: Int) {
        holder.bind(listMeals[position])
    }

    override fun getItemCount(): Int {
        return listMeals.size
    }

    fun setData(newList: MutableList<BeefMealCacheModel>) {
        val diffUtil = AdapterBeefCacheDiffUtils(listMeals, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        listMeals.clear()
        listMeals.addAll(newList)
        diffResults.dispatchUpdatesTo(this)
    }

}