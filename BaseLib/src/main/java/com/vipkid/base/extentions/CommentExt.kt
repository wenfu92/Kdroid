package com.vipkid.base.extentions

import com.ashokvarma.bottomnavigation.BottomNavigationBar

/**
 * Created by WWF
 * on 2019/5/1
 */
fun BottomNavigationBar.addSelectListener(method: () -> Unit): BottomNavigationBar {
    setTabSelectedListener(method)
    return this
}

fun setTabSelectedListener(method: () -> Unit) {
    setTabSelectedListener(method)
}
