package com.kotlin.helper.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
abstract class BaseInitActivity : AppCompatActivity() {

    abstract val layoutId: Int

    var dataBindView :View? = null

}