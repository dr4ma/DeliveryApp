package com.example.fooddelivery.presentation.fragments.profilefragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val mViewModel: ProfileViewModel by viewModels()
    private var binding: FragmentProfileBinding? = null
    private val mBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}