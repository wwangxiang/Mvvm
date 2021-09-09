package com.kotlin.mvvm.data.response

/**
 * 时间　: 2020/11/18
 * 作者　: hegaojian
 * 描述　: 服务器返回的数据基类
 */
data class ApiResponse<T>(
    var data: T,
    var code: Int = -1,
    var Msg: String = ""
)