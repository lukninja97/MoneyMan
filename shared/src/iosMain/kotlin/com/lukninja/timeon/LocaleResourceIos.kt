package com.lukninja.timeon

import com.lukninja.timeon.localize.*

fun localizeString(key: String): String {
    return key.localizeString()
}

fun replaceValue(key: String, value: String): String {
    return key.replaceValue(value = value)
}

fun replaceValues(key: String, values: List<String>): String {
    return key.replaceValues(values = values)
}