package com.kotlin.mvvm.app

import android.app.Application
import com.effective.android.anchors.AnchorsManager
import com.effective.android.anchors.Project
import com.kotlin.helper.ext.currentProcessName
import com.kotlin.mvvm.BuildConfig

/**
 * 作者　: wangxiang
 * 时间　: 2021/6/9
 * 描述　:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val processName = currentProcessName
        if (processName == packageName) {
            // 主进程初始化
            onMainProcessInit()
        } else {
            // 其他进程初始化
            processName?.let { onOtherProcessInit(it) }
        }
    }

    /**
     * @description  代码的初始化请不要放在onCreate直接操作，按照下面新建异步方法
     */
    private fun onMainProcessInit() {
        AnchorsManager.getInstance()
            .debuggable(BuildConfig.DEBUG)
            //设置锚点
            .addAnchor(InitNetWork.TASK_ID, InitUtils.TASK_ID, InitComm.TASK_ID, InitToast.TASK_ID)
            .start(Project.Builder("app", AppTaskFactory())
                    .add(InitNetWork.TASK_ID)
                    .add(InitComm.TASK_ID)
                    .add(InitUtils.TASK_ID)
                    .add(InitToast.TASK_ID)
                    .build()
            )
    }

    /**
     * 其他进程初始化，[processName] 进程名
     */
    private fun onOtherProcessInit(processName: String) {}

}