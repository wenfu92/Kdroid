package com.vipkid.base
import android.app.Activity
import android.app.Application
import android.content.ContextWrapper
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.onAdaptListener

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
        AutoSizeConfig.getInstance()
                .setCustomFragment(true).onAdaptListener = object : onAdaptListener {
            override fun onAdaptBefore(target: Any, activity: Activity) {
            }

            override fun onAdaptAfter(target: Any, activity: Activity) {
            }
        }
    }

    companion object {
        @JvmStatic
        lateinit var instance : VipKidApp
    }
    object AppContext:ContextWrapper(instance)
}