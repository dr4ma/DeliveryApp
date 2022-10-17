package com.example.fooddelivery.presentation.fragments.menuFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ItemOffersRecyclerBinding
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: ItemOffersRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            with(binding) {
                when (position) {
                    0 -> {
                        imageOffer.setImageDrawable(
                            APP_ACTIVITY_MAIN.resources.getDrawable(
                                R.drawable.first_banner,
                                APP_ACTIVITY_MAIN.theme
                            )
                        )
                    }
                    1 -> {
                        imageOffer.setImageDrawable(
                            APP_ACTIVITY_MAIN.resources.getDrawable(
                                R.drawable.second_banner,
                                APP_ACTIVITY_MAIN.theme
                            )
                        )
                    }
                    2 -> {
                        imageOffer.setImageDrawable(
                            APP_ACTIVITY_MAIN.resources.getDrawable(
                                R.drawable.third_banner,
                                APP_ACTIVITY_MAIN.theme
                            )
                        )
                    }
                    3 -> {
                        imageOffer.setImageDrawable(
                            APP_ACTIVITY_MAIN.resources.getDrawable(
                                R.drawable.forth_banner,
                                APP_ACTIVITY_MAIN.theme
                            )
                        )
                    }
                    4 -> {
                        imageOffer.setImageDrawable(
                            APP_ACTIVITY_MAIN.resources.getDrawable(
                                R.drawable.fifth_banner,
                                APP_ACTIVITY_MAIN.theme
                            )
                        )
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemOffersRecyclerBinding.inflate(LayoutInflater.from(APP_ACTIVITY_MAIN), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 5
    }
}