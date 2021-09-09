package com.kotlin.mvvm.data.repository

import com.kotlin.mvvm.app.api.NetUrl
import com.kotlin.mvvm.data.response.ApiPagerResponse
import com.kotlin.mvvm.data.response.UserInfo
import rxhttp.IAwait
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse

/**
 * 作者　: hegaojian
 * 时间　: 2020/11/2
 * 描述　: 数据仓库
 */
object UserRepository {

    /**
     * 登录
     */
    fun login(userName: String, password: String): IAwait<UserInfo> {
        return RxHttp.postForm(NetUrl.LOGIN)
            .add("username", userName)
            .add("password", password)
            .toResponse()
    }

    /**
     * 获取列表信息
     */
    fun getList(pageIndex: Int): IAwait<ApiPagerResponse<Any>> {
        return RxHttp.get(NetUrl.HOME_LIST, pageIndex)
            .toResponse()
    }

}

