package com.example.fooddelivery.presentation.fragments.chickenFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.fooddelivery.databinding.FragmentChickenBinding
import com.example.fooddelivery.domain.models.retrofit.ResultMealModel
import com.example.fooddelivery.domain.models.room.ChickenCacheModel
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN
import com.example.fooddelivery.utils.CHICKEN_CATEGORY
import com.example.fooddelivery.utils.CONNECTED
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChickenFragment : Fragment() {
    private lateinit var mObserverListMeals: Observer<MutableList<ResultMealModel>>
    private lateinit var mObserverListCacheMeals: Observer<MutableList<ChickenCacheModel>>

    private val mViewModel: ChickenViewModel by viewModels()
    private var binding: FragmentChickenBinding? = null
    private val mBinding get() = binding!!

    @Inject
    lateinit var mAdapter : ChickenAdapter
    @Inject
    lateinit var mAdapterCache: ChickenCacheAdapter

    private lateinit var mRecycler : RecyclerView
    private lateinit var mProgress : ProgressBar
    private lateinit var mSwipe: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChickenBinding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mRecycler = chickenRecycler
            mProgress = progressRecycler
            mSwipe = swipeRefresh
        }
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initFields()
        initObservers()

        if(CONNECTED){
            mViewModel.getCategory(CHICKEN_CATEGORY){}
        }
        else{
            mViewModel.getCacheChicken()
            mRecycler.adapter = mAdapterCache
            mViewModel.cacheChickenList.observe(APP_ACTIVITY_MAIN, mObserverListCacheMeals)
        }
    }

    private fun initObservers(){
        // Observer Retrofit
        mObserverListMeals = Observer {
            mProgress.visibility = View.GONE
            mAdapter.setData(it)
            mSwipe.isRefreshing = false
        }
        mViewModel.mealsList.observe(APP_ACTIVITY_MAIN, mObserverListMeals)

        // Observer Room
        mObserverListCacheMeals = Observer {
            mProgress.visibility = View.GONE
            mAdapterCache.setData(it)
        }
    }

    private fun initFields() {
        mAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        mRecycler.adapter = mAdapter
        if(mAdapter.itemCount == 0){
            mProgress.visibility = View.VISIBLE
        }
        mSwipe.setOnRefreshListener {
            if(CONNECTED){
                mViewModel.getCategory(CHICKEN_CATEGORY){
                    mRecycler.adapter = mAdapter
                }
            }
            else{
                mSwipe.isRefreshing = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}