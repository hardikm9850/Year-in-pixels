package com.hady.yip

class Utils {
    companion object {
        val COLUMN_SIZE = 13
        val ROW_SIZE = 30

        val listOfBlockedDates = arrayOf(
            (COLUMN_SIZE * 28) + 2,
            (COLUMN_SIZE * 29) + 2,
            (COLUMN_SIZE * 30) + 2,
            (COLUMN_SIZE * 30) + 4,
            (COLUMN_SIZE * 30) + 6,
            (COLUMN_SIZE * 30) + 9,
            (COLUMN_SIZE * 30) + 11
        )

        val listOfBlockedDatesForLeapYear = listOfBlockedDates.copyOfRange(1, listOfBlockedDates.size)
    }
}