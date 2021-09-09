package com.kotlin.mvvm.app.ext

import android.view.View
import com.kotlin.mvvm.R
import com.kotlin.mvvm.app.widget.CustomToolBar

/**
 * 作者　: user
 * 时间　: 2021/6/9
 * 描述　:
 */

fun CustomToolBar.initBack(
    titleStr: String = "标题",
): CustomToolBar {
    this.setCenterTitle(titleStr)
    return this
}

fun CustomToolBar.initBack(
    titleStr: String = "标题",
    mImg: Int,
    mOnClick: View.OnClickListener,
    bearing: Boolean
): CustomToolBar {
    this.setCenterTitle(titleStr)
    if (bearing) {
        this.setLeftImage(mImg)
        this.setLeftImageListener(mOnClick)
    }else{
        this.setRightImage(mImg)
        this.setRightImageListener(mOnClick)
    }
    return this
}

fun CustomToolBar.initBack(
    titleStr: String = "标题",
    mString: String,
    mOnClick: View.OnClickListener,
    bearing: Boolean
): CustomToolBar {
    this.setCenterTitle(titleStr)
    if (bearing) {
        this.setLeftText(mString)
        this.setLeftTextListener(mOnClick)
    } else {
        this.setRightText(mString)
        this.setRightTextListener(mOnClick)
    }
    return this
}

fun CustomToolBar.initBack(
    titleStr: String = "标题",
    left: Int,
    onLeft: View.OnClickListener,
    right: Int,
    onRight: View.OnClickListener
): CustomToolBar {
    this.setCenterTitle(titleStr)
    this.setLeftImage(left)
    this.setLeftImageListener(onLeft)
    this.setRightImage(right)
    this.setRightImageListener(onRight)
    return this
}
