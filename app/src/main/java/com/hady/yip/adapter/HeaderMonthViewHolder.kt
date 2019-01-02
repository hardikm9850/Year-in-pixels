package com.hady.yip.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.hady.yip.R

class HeaderMonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var month: TextView = itemView.findViewById(R.id.txt_month)
}