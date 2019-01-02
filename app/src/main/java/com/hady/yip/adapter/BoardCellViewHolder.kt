package com.hady.yip.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.hady.yip.R

class BoardCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var frame: TextView = itemView.findViewById(R.id.square)
}