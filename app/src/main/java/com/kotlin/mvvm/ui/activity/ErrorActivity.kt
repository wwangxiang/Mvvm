package com.kotlin.mvvm.ui.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import com.blankj.utilcode.util.ToastUtils
import com.kotlin.helper.base.BaseViewModel
import com.kotlin.helper.ext.clickNoRepeat
import com.kotlin.helper.ext.showDialogMessage
import com.kotlin.mvvm.R
import com.kotlin.mvvm.app.base.BaseActivity
import com.kotlin.mvvm.databinding.ActivityErrorBinding

class ErrorActivity : BaseActivity<BaseViewModel, ActivityErrorBinding>() {

    override val layoutId: Int = R.layout.activity_error

    override fun initView(savedInstanceState: Bundle?) {

        val config = CustomActivityOnCrash.getConfigFromIntent(intent)
        val clipboardManager: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        mDataBind.errorRestart.clickNoRepeat {
            config?.run {
                CustomActivityOnCrash.restartApplication(this@ErrorActivity, this)
            }
        }
        mDataBind.errorSendError.clickNoRepeat {
            CustomActivityOnCrash.getStackTraceFromIntent(intent)?.let {
                showDialogMessage(it, "错误报告", "复制", {
                    val mClipData = ClipData.newPlainText("errorLog", it)
                    // 将ClipData内容放到系统剪贴板里。
                    clipboardManager.setPrimaryClip(mClipData)
                    ToastUtils.showShort("已复制错误日志")
                }, "取消")
            }


        }

    }

}