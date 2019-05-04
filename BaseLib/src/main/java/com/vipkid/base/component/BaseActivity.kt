package com.vipkid.base.component

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vipkid.base.extentions.yes
import org.greenrobot.eventbus.EventBus

/**
 * Created by WWF
 * on 2019/5/3
 */
abstract class BaseActivity : AppCompatActivity() {
    //避开与某些闭包内的this冲突
    protected val self: Activity by lazy {
        this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId());
        EventBus.getDefault().register(this)
        initData()

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().isRegistered(Any()).yes {
            EventBus.getDefault().unregister(this)
        }
    }
    abstract fun getLayoutId(): Int
    /**
     * 加载数据
     */
    abstract  fun initData()

}