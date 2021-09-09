package com.kotlin.mvvm.app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.kotlin.mvvm.R

/**
 * 作者　: user
 */
class CustomToolBar : FrameLayout {

    private lateinit var toolbar: FrameLayout
    private lateinit var leftImage: AppCompatImageView
    private lateinit var leftText: AppCompatTextView
    private lateinit var title: AppCompatTextView
    private lateinit var rightImage: AppCompatImageView
    private lateinit var rightText: AppCompatTextView

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val view = LayoutInflater.from(context).inflate(R.layout.toolbar_layout_custom, this)
        toolbar = view.findViewById(R.id.toolbar)
        leftImage = view.findViewById(R.id.left_image)
        leftText = view.findViewById(R.id.left_text)
        title = view.findViewById(R.id.title)
        rightImage = view.findViewById(R.id.right_image)
        rightText = view.findViewById(R.id.right_text)
    }

    fun setToolbarBackGround(colorResId: Int) {
        toolbar.setBackgroundColor(colorResId)
    }

    fun setCenterTitle(titleStr: String) {
        title.text = titleStr
    }

    fun setCenterTitle(titleResId: Int) {
        title.text = context.getString(titleResId)
    }

    fun setCenterTitleColor(colorResId: Int) {
        title.setTextColor(colorResId)
    }

    fun setLeftImage(colorResId: Int) {
        leftImage.setBackgroundResource(colorResId)
    }

    fun setLeftImageListener(listener: OnClickListener) {
        leftImage.setOnClickListener(listener)
    }

    fun setLeftText(titleStr: String) {
        leftText.text = titleStr
    }

    fun setLeftTextListener(listener: OnClickListener) {
        leftText.setOnClickListener(listener)
    }

    fun setRightImage(colorResId: Int) {
        rightImage.setBackgroundResource(colorResId)
    }

    fun setRightImageListener(listener: OnClickListener) {
        rightImage.setOnClickListener(listener)
    }

    fun setRightText(titleStr: String) {
        rightText.text = titleStr
    }

    fun setRightTextListener(listener: OnClickListener) {
        rightText.setOnClickListener(listener)
    }

}
