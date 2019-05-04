package com.vipkid.base.extentions

import android.app.Activity
import android.view.View
import android.view.ViewGroup

/**
 * Created by WWF
 * on 2019/5/1
 */
val Activity.contentView: View? get() = findViewById<ViewGroup>(android.R.id.content)?.getChildAt(0)