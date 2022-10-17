package com.example.fooddelivery.presentation.fragments.miscellaneousFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddelivery.R

class MiscellaneousFragment : Fragment() {

    companion object {
        fun newInstance() = MiscellaneousFragment()
    }

    private lateinit var viewModel: MiscellaneousViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_miscellaneous, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MiscellaneousViewModel::class.java)
        // TODO: Use the ViewModel
    }

}