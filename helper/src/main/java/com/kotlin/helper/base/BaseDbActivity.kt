package com.kotlin.helper.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentHostCallback
import com.noober.background.BackgroundLibrary
import java.lang.reflect.ParameterizedType

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
abstract class BaseDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>(),
    BaseIView {

    //使用了DataBinding 就不需要 layoutId了，因为 会从DB泛型 找到相关的view
    override val layoutId: Int = 0

    lateinit var mDataBind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        initDataBind()
        super.onCreate(savedInstanceState)
    }

    /**
     * 创建DataBinding
     */
    @Suppress("UNCHECKED_CAST")
    private fun initDataBind() {
        //利用反射 根据泛型得到 ViewDataBinding
        val superClass = javaClass.genericSuperclass
        val aClass = (superClass as ParameterizedType).actualTypeArguments[1] as Class<*>
        BackgroundLibrary.inject(this)
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mDataBind = method.invoke(null, layoutInflater) as DB
        dataBindView = mDataBind.root
        mDataBind.lifecycleOwner = this
    }

}