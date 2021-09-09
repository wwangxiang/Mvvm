package com.kotlin.mvvm.app.api

import rxhttp.wrapper.annotation.DefaultDomain

/**
 * 作者　: wangxiang
 * 时间　: 2021/6/9
 * 描述　:
 */
object NetUrl {

    // 服务器请求成功的 Code值
    const val SUCCESS_CODE = 0

    @DefaultDomain //设置为默认域名
    const val DEV_URL = "https://wanandroid.com/"

    //登录
    const val LOGIN = "user/login"

    //获取首页列表数据
    const val HOME_LIST = "article/list/%1\$d/json"

}