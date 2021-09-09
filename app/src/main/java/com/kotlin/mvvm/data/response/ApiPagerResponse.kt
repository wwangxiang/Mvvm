package com.kotlin.mvvm.data.response

import com.kotlin.helper.entity.BasePage

/**
 * 作者　: hegaojian
 * 时间　: 2020/11/18
 * 描述　: 服务器返回的列表数据基类
 */
data class ApiPagerResponse<T>(
    var datas: ArrayList<T>,
    var curPage: Int,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int
) : BasePage<T>() {
    override fun getPageData() = datas
    override fun isRefresh() = offset == 0
    override fun isEmpty() = datas.isEmpty()
    override fun hasMore() = !over
}




