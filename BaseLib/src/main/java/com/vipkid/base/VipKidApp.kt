package com.vipkid.base
import android.app.Application
import android.content.ContextWrapper
import me.jessyan.autosize.AutoSizeConfig

/**
 * Created by WWF
 * on 2019/4/30
 */
class VipKidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance=this
        initConfigAutoSize()
    }

    private fun initConfigAutoSize() {
    }

    companion object {
        @JvmStatic
        lateinit var instance : VipKidApp
    }
    object AppContext:ContextWrapper(instance)
}