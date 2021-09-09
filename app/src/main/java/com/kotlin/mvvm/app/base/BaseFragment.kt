package com.kotlin.mvvm.app.base

import androidx.databinding.ViewDataBinding
import com.kotlin.helper.base.BaseDbFragment
import com.kotlin.helper.base.BaseViewModel

/**
 * 作者　: wangxiang
 * 时间　: 2021/6/9
 * 描述　:
 */
abstract class BaseFragment<VM : BaseViewModel,DB: ViewDataBinding> : BaseDbFragment<VM, DB>(){

    //需要自定义修改什么就重写什么

}