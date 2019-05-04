package com.vipkid.base.extentions

import android.view.View

/**
 * Created by WWF
 * on 2019/5/1
 */
var View.topPadding:Int
    inline get() = paddingTop
    set(value) = setPadding(paddingLeft,value,paddingRight,paddingBottom)