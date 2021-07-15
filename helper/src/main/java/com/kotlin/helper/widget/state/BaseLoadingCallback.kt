package com.kotlin.helper.widget.state

import android.content.Context
import android.view.View
import com.kingja.loadsir.callback.Callback
import com.kotlin.helper.R

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
class BaseLoadingCallback: Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_loading
    }

    /**
     * 是否是 点击不可重试
     */
    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}