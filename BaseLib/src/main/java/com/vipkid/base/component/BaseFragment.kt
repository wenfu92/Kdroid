package com.vipkid.base.component

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vipkid.base.extentions.yes

/**
 * Created by WWF
 * on 2019/5/3
 */
abstract class BaseFragment : Fragment() {
    private var isInt = false
    private var isFristVisible = false
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        (isVisibleToUser && isFristVisible && isInt).yes {
            initdata()
            isInt = false
        }
    }

    /**
     * 加载数据
     */
    abstract fun initdata()

    /**
     * 加载View
     */
    abstract fun initView()

    /**
     * 加载XML文件
     */
    @LayoutRes
    abstract fun getLayoutId():Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),container,false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        isInt = true
        userVisibleHint.yes {
            initdata()
            isFristVisible = false
        }
    }
}