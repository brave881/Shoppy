package com.brave.shoppy.utils

fun String.isEmail(): Boolean {
    val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")
    return this.matches(emailRegex)
}

fun String.isPhone(): Boolean {
    val phoneRegex = Regex("^\\+?[1-9]\\d{1,14}$")
    return this.matches(phoneRegex)
}