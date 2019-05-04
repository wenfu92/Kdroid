package com.vipkid.find.ui.fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.vipkid.base.component.BaseFragment
import com.vipkid.find.R
import com.vipkid.find.viewModel.FindViewModel

/**
 *Created by WWF
 */
class FindFragment : BaseFragment() {
    /**
     * 网络请求回来的model
     */
    private val model by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(FindViewModel::class.java)
    }
    override fun initView() {

    }

    override fun initdata() {
      model.getHistory().observe(this, Observer{
          it?.let {
              //显示数据
          }

      })

        model.refrosh()
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_find
    }

}
