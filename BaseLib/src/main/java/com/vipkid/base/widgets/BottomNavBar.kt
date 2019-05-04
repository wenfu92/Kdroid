package com.vipkid.base.widgets
import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.vipkid.base.R

/**
 * Created by WWF
 * on 2019/4/30
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {
    init {
        val homeItem=BottomNavigationItem(R.mipmap.bottom_dingzhi_selected,resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.mipmap.bottom_dingzhi_normal)
                .setActiveColorResource(R.color.common_yellow)
                .setInActiveColorResource(R.color.text_normal)

        val readItem=BottomNavigationItem(R.mipmap.bottom_study_selected,resources.getString(R.string.nav_bar_category))
                .setInactiveIconResource(R.mipmap.bottom_study_normal)
                .setActiveColorResource(R.color.common_yellow)
                .setInActiveColorResource(R.color.text_normal)
        val categroyItem=BottomNavigationItem(R.mipmap.bottom_list_selected,resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.mipmap.bottom_list_normal)
                .setActiveColorResource(R.color.common_yellow)
                .setInActiveColorResource(R.color.text_normal)
        val userItem=BottomNavigationItem(R.mipmap.bottom_user_selected,resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.mipmap.bottom_user_normal)
                .setActiveColorResource(R.color.common_yellow)
                .setInActiveColorResource(R.color.text_normal)
        addItem(homeItem)
                .addItem(readItem)
                .addItem(categroyItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)
                .setMode(MODE_FIXED)
                .initialise()
        this.setHasTransientState(true)
    }
}