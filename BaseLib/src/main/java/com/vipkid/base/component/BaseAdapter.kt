package com.vipkid.base.component
import android.support.v7.widget.RecyclerView
/**
 * Created by WWF
 * on 2019/5/4
 * BaseAdapter 使用RecyclerView 的基类
 */
abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>() : RecyclerView.Adapter<VH>() {

    //ItemClick事件
    var mItemClickListener: OnItemClickListener<T>? = null

    //数据集合
    var dataList: MutableList<T> = mutableListOf()

    /*
        设置数据
        Presenter处理过为null的情况，所以为不会为Null
     */
    fun setData(sources: MutableList<T>) {
        dataList = sources
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mItemClickListener != null)
                mItemClickListener!!.onItemClick(dataList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    /**
     * item点击事件
     */
    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mItemClickListener = listener
    }
}