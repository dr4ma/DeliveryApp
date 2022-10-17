package com.example.fooddelivery.presentation.fragments.menuFragment

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.utils.showToast
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val mViewModel: MenuViewModel by viewModels()

    private lateinit var mSpinner: Spinner
    private lateinit var mToolbar: Toolbar
    private lateinit var mRecyclerView: RecyclerView

    @Inject
    lateinit var mAdapter: MenuAdapter
    private lateinit var mTabAdapter: MenuPagerAdapter

    private var binding: FragmentMenuBinding? = null
    private val mBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mSpinner = spinnerCities
            mToolbar = mainToolbar
            mRecyclerView = offers
        }
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(mToolbar)
        (activity as AppCompatActivity).title = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initFields()
        initSpinner()
        initTabLayout()
    }

    private fun initFields() {
        mAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        mRecyclerView.adapter = mAdapter
    }

    private fun initTabLayout() {
        mBinding.apply {
            mTabAdapter = MenuPagerAdapter(childFragmentManager, lifecycle)
            viewPagerCategories.adapter = mTabAdapter
            TabLayoutMediator(tabCategories, viewPagerCategories) { tab, position ->
                when (position) {
                    0 -> tab.text = getString(R.string.beef)
                    1 -> tab.text = getString(R.string.chicken)
                    2 -> tab.text = getString(R.string.dessert)
                    3 -> tab.text = getString(R.string.lamb)
                    4 -> tab.text = getString(R.string.miscellaneous)
                }
            }.attach()
        }
    }

    private fun initSpinner() {
        val arrayAdapter = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.spinner_items,
                R.layout.spinner_layout
            )
        }
        mSpinner.adapter = arrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.main_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.scan_qr -> showToast(getString(R.string.scanning_qr))
        }

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}