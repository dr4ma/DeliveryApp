package com.example.fooddelivery.presentation.fragments.lambFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddelivery.R

class LambFragment : Fragment() {

    companion object {
        fun newInstance() = LambFragment()
    }

    private lateinit var viewModel: LambViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lamb, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LambViewModel::class.java)
        // TODO: Use the ViewModel
    }

}