package com.kotlin.mvvm.ui.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.blankj.utilcode.util.ToastUtils
import com.kotlin.helper.base.BaseViewModel
import com.kotlin.helper.base.BaseVmActivity
import com.kotlin.mvvm.R

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseVmActivity<BaseViewModel/*, ActivityMainBinding*/>() {

    private var exitTime = 0L

    override fun initView(savedInstanceState: Bundle?) {
        //初始化toolbar
//               mToolbar.initBack(
//                   getStringExt(R.string.string_main), R.drawable.ic_back, mOnClick = {
//            finish()
//        }, true
//        )
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainfragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    nav.navigateUp()
                } else {
                    //是主页
                    if (System.currentTimeMillis() - exitTime > 2000) {
                        ToastUtils.showShort("再按一次退出程序")
                        exitTime = System.currentTimeMillis()
                    } else {
                        finish()
                    }
                }
            }
        })
    }

}