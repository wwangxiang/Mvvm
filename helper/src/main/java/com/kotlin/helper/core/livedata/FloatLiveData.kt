package com.kotlin.helper.core.livedata

import androidx.lifecycle.MutableLiveData

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 * 描述　:自定义的Float类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class FloatLiveData(value: Float = 0f) : MutableLiveData<Float>(value) {
    override fun getValue(): Float {
        return super.getValue()!!
    }
}