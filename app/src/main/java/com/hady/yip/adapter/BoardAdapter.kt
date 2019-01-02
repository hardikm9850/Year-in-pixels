package com.hady.yip.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hady.yip.R
import java.util.*

class BoardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list = ArrayList<BoardModel>()

    init {
        list = ArrayList()
    }

    fun setData(data : ArrayList<BoardModel>){
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType : Int): RecyclerView.ViewHolder {
        return when(itemType){
            BoardModel.TYPE_EMPTY_CELL -> BoardCellViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_empty_square,viewGroup,false))
            BoardModel.TYPE_BLOCKED_CELL -> DayViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_day_square,viewGroup,false))
            BoardModel.TYPE_INVALID_CELL -> DayViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_blocked_square,viewGroup,false))
            else -> DayViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_day_square,viewGroup,false))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position : Int) {
        val data = list[position]
        when(data.itemType){
            BoardModel.TYPE_EMPTY_CELL -> fillEntry(data, viewHolder as BoardCellViewHolder,position)
            BoardModel.TYPE_BLOCKED_CELL -> createDayCell(data, viewHolder as DayViewHolder)
        }
    }

    private fun createDayCell(data: BoardModel, viewHolder: DayViewHolder) {
        viewHolder.day.text = data.dayCell.toString()
    }

    private fun fillEntry(
        data: BoardModel,
        viewHolder: BoardCellViewHolder,
        position: Int) {
        viewHolder.frame.setBackgroundColor(getColorForUserInput(data.userMood))
    }

    private fun getColorForUserInput(userMood: UserMood): Int {
        //TODO return appropriate color
        return android.R.color.holo_orange_light
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].itemType
    }
}