package com.example.fooddelivery.presentation.fragments.menuFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fooddelivery.presentation.fragments.beefFragment.BeefFragment
import com.example.fooddelivery.presentation.fragments.chickenFragment.ChickenFragment
import com.example.fooddelivery.presentation.fragments.dessertFragment.DessertFragment
import com.example.fooddelivery.presentation.fragments.lambFragment.LambFragment
import com.example.fooddelivery.presentation.fragments.miscellaneousFragment.MiscellaneousFragment

class MenuPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BeefFragment()
            1 -> ChickenFragment()
            2 -> DessertFragment()
            3 -> LambFragment()
            4 -> MiscellaneousFragment()
            else ->Fragment()
        }
    }

}