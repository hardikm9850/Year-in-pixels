package com.hady.yip.adapter

class BoardModel(var itemType: Int, var position : Int, var userMood: UserMood,var dayCell : Int) {

    companion object {
        val TYPE_BLOCKED_CELL = 0
        val TYPE_EMPTY_CELL = 1
        val TYPE_INVALID_CELL = 2
    }

    override fun toString(): String {
        return "item type $itemType , daycell $dayCell"
    }
}
