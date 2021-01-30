package com.frogobox.frogoadmobhelper.boilerplate.shimmerrclass

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.frogoadmobhelper.R
import com.frogobox.frogoadmobhelper.base.parent.FrogoRecyclerViewListener
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewAdapter
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewAdapterCallback
import com.frogobox.frogoadmobhelper.boilerplate.viewrclass.FrogoViewHolderCallback
import com.frogobox.frogoadmobhelper.util.FrogoRvConstant
import com.frogobox.frogoadmobhelper.widget.FrogoAdmobRecyclerView

/*
 * Created by Faisal Amir on 04/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoSrvSingletonShimmer : IFrogoSrvSingletonShimmer {

    private lateinit var mFrogoShimmerAdmobRecyclerView: FrogoAdmobRecyclerView
    private lateinit var srvFrogoAdapterCallback: FrogoViewAdapterCallback<String>
    private lateinit var srvFrogoViewAdapter: FrogoViewAdapter<String>

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var srvSumListItem: Int = 2
    private var srvCustomViewInt: Int = 0

    override fun initSingleton(frogoShimmerAdmobRecyclerView: FrogoAdmobRecyclerView): FrogoSrvSingletonShimmer {
        mFrogoShimmerAdmobRecyclerView = frogoShimmerAdmobRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingletonShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingletonShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingletonShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSrvSingletonShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingletonShimmer {
        srvCustomViewInt = customViewInt
        Log.d("injector-shimmerView", srvCustomViewInt.toString())
        return this
    }

    override fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingletonShimmer {
        srvSumListItem = sumItem
        Log.d("injector-sumItem", srvSumListItem.toString())
        return this
    }

    private fun srvListData(): MutableList<String> {
        val listdata = mutableListOf<String>()
        for (i in 1..srvSumListItem) {
            listdata.add("place-holder-shimmer")
        }
        return listdata
    }

    private fun setupLayoutManager() {
        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            mFrogoShimmerAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoShimmerAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.VERTICAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            mFrogoShimmerAdmobRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            if (optionDividerItem) {
                mFrogoShimmerAdmobRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerAdmobRecyclerView.context, LinearLayoutManager.HORIZONTAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoShimmerAdmobRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoShimmerAdmobRecyclerView.layoutManager = GridLayoutManager(mFrogoShimmerAdmobRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createShimmerRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        srvFrogoAdapterCallback = object : FrogoViewAdapterCallback<String>{
            override fun setupInitComponent(view: View, data: String) {}
            override fun onItemClicked(data: String) {}
            override fun onItemLongClicked(data: String) {}
        }

        srvFrogoViewAdapter = FrogoViewAdapter(object : FrogoViewHolderCallback<String> {
            override fun setupInitComponent(view: View, data: String) {
                srvFrogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        srvFrogoViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                FrogoRecyclerViewListener<String> {
                override fun onItemClicked(data: String) {
                    srvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: String) {
                    srvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        srvFrogoViewAdapter.setupEmptyView(emptyViewInt)
    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoShimmerAdmobRecyclerView.adapter = srvFrogoViewAdapter
    }

    override fun build(): FrogoSrvSingletonShimmer {
        createShimmerRvAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}