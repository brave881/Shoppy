package com.brave.shoppy.utils.validators



fun trimmerDate(it: String): String {
    val trimme = if (it.length >= 4) it.substring(0..3) else it
    var result = ""
    for (j in trimme.indices) {
        result += trimme[j]
        if (j == 1) result += "/"
    }
    return result
}

fun trimmerCardNumber(cardNumber: String): String {
    val trimmed = if (cardNumber.length >= 16) cardNumber.substring(0..15) else cardNumber
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i == 3 || i == 7 || i == 11) out += " "
    }
    return out
}
