package com.kotlin.helper.widget.state

import com.kingja.loadsir.callback.Callback
import com.kotlin.helper.R

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
class BaseEmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }

}