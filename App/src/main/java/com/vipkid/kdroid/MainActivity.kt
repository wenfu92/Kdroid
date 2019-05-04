package com.vipkid.kdroid
import android.graphics.Color
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.vipkid.base.component.BaseActivity
import com.vipkid.base.extentions.contentView
import com.vipkid.base.extentions.topPadding
import com.vipkid.find.ui.fragment.FindFragment
import com.vipkid.home.HomeFragment
import getStatusBarHeight
import kotlinx.android.synthetic.main.activity_main.*
import setStatusTransAndDarkIcon
import java.util.*

class MainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        setStatusTransAndDarkIcon(Color.WHITE)
        //获取状态栏的高
        contentView?.topPadding = getStatusBarHeight()
        initFragment()
        initBottomBar()
        changeFragment(0)
    }

    private val mStack = Stack<Fragment>()
    private val mHomeFragment by lazy { HomeFragment() }
    private val mFindFragment by lazy { FindFragment() }
    private val mCategoryFragment by lazy { HomeFragment() }
    private val mUserFragment by lazy { HomeFragment() }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.mFramlayout, mHomeFragment)
        fragmentManager.add(R.id.mFramlayout, mFindFragment)
        fragmentManager.add(R.id.mFramlayout, mCategoryFragment)
        fragmentManager.add(R.id.mFramlayout, mUserFragment)
        fragmentManager.commit()
        mStack.add(mHomeFragment)
        mStack.add(mFindFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mUserFragment)
    }

    private fun initBottomBar() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }

        })

    }

    private fun changeFragment(position: Int) {
        var fragmentManager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            fragmentManager.hide(fragment)
        }
        fragmentManager.show(mStack[position])
        fragmentManager.commit()
    }
}
