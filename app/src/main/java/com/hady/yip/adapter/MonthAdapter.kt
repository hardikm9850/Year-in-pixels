package com.hady.yip.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hady.yip.R
import java.util.*

class MonthAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = ArrayList<String>()

    init {
        list = ArrayList()
        val monthIterator = charArrayOf(' ','J','F','M','A','M','J','J','A','S','O','N','D').iterator()
        monthIterator.forEach {
            list.add(it.toString())
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType : Int): RecyclerView.ViewHolder {
        return HeaderMonthViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_month_square,viewGroup,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position : Int) {
        val data = list[position]
        fillMonth(data,viewHolder)
        Log.d("####", "position $position")
    }

    private fun fillMonth(data : String, viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as HeaderMonthViewHolder).month.text = data
    }
}