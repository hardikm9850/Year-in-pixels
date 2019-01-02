package com.hady.yip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.hady.yip.Utils.Companion.COLUMN_SIZE
import com.hady.yip.Utils.Companion.listOfBlockedDates
import com.hady.yip.Utils.Companion.listOfBlockedDatesForLeapYear
import com.hady.yip.adapter.BoardAdapter
import com.hady.yip.adapter.BoardModel
import com.hady.yip.adapter.MonthAdapter
import com.hady.yip.adapter.UserMood


class MainActivity : AppCompatActivity() {

    private lateinit var pixelBoard: RecyclerView
    private lateinit var monthBoard: RecyclerView

    private val dummyDate = ArrayList<BoardModel>()
    private val totalCells = 402

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        val monthAdapter = MonthAdapter()
        val pixelAdapter = BoardAdapter()
        initDummyData()

        pixelAdapter.setData(dummyDate)
        pixelBoard = findViewById(R.id.recycler_board)
        monthBoard = findViewById(R.id.recycler_month)

        setupRecyclerView(pixelBoard, pixelAdapter)
        setupRecyclerView(monthBoard, monthAdapter)
    }

    private fun initDummyData() {
        for (i in 0..totalCells) {
            val itemType = when (isValidDay(i)) {
                true -> BoardModel.TYPE_BLOCKED_CELL
                false -> BoardModel.TYPE_EMPTY_CELL
            }
            val dayCell = when (isValidDay(i)) {
                true -> (i / 13) + 1
                false -> 0
            }
            dummyDate.add(BoardModel(itemType, i, UserMood.EMPTY, dayCell))
        }
        for (blockedDay in listOfBlockedDates) {
            //TODO get current year and setup february cell invalid accordingly
            dummyDate[blockedDay] = BoardModel(BoardModel.TYPE_INVALID_CELL, blockedDay, UserMood.EMPTY, 0)
        }
    }

    private fun isValidDay(value: Int): Boolean {
        return value % COLUMN_SIZE == 0
    }

    private fun setupRecyclerView(board: RecyclerView, pixelAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        board.setHasFixedSize(true)
        board.layoutManager = GridLayoutManager(this, COLUMN_SIZE)
        board.adapter = pixelAdapter
    }
}
