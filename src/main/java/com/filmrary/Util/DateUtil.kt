package com.filmrary.Util

import com.filmrary.exception.WrongDateException
import java.util.*

fun checkDate(date: Date?, fieldName: String) {
    if (date == null) {
        throw WrongDateException("$fieldName must not be null")
    }

    if (date.after(Date())) {
        throw WrongDateException("$fieldName date is in future")
    }
}