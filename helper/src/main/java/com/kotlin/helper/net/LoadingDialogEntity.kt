package com.kotlin.helper.net

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
data class LoadingDialogEntity(
    @LoadingType var loadingType: Int = LoadingType.LOADING_NULL,
    var loadingMessage: String = "",
    var isShow: Boolean = false,
    var requestCode: String = "mmp"
)