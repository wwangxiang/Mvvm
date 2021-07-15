package com.kotlin.helper.ext

/**
 * 作者　: wangxiang
 * 时间　: 2021/7/15
 */
inline fun <reified T> T?.notNull(notNullAction: (T) -> Unit, nullAction: () -> Unit) {
    if (this != null) {
        notNullAction.invoke(this)
    } else {
        nullAction.invoke()
    }
}
