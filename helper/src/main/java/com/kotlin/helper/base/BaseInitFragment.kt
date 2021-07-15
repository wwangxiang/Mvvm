package com.kotlin.helper.base

import android.view.View
import androidx.fragment.app.Fragment

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
abstract class BaseInitFragment : Fragment() {

    abstract val layoutId: Int

    var dataBindView : View? = null
}