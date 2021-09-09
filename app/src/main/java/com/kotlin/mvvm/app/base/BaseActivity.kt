package com.kotlin.mvvm.app.base

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.kotlin.helper.base.BaseDbActivity
import com.kotlin.helper.base.BaseViewModel
import com.kotlin.mvvm.R
import com.kotlin.mvvm.app.widget.CustomToolBar

/**
 * 作者　: wangxiang
 * 时间　: 2021/6/9
 * 描述　:
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseDbActivity<VM, DB>() {

    lateinit var mToolbar: CustomToolBar

    override fun getTitleBarView(): View? {
        val titleBarView = LayoutInflater.from(this).inflate(R.layout.layout_titlebar_view, null)
        mToolbar = titleBarView.findViewById(R.id.customToolBar)
        return titleBarView
    }

    override fun initImmersionBar() {
        //设置共同沉浸式样式
        if (showToolBar()) {
            mToolbar.setBackgroundResource(R.color.colorPrimary)
            ImmersionBar.with(this).titleBar(mToolbar).init()
        }
    }

}