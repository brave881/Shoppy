package com.brave.shoppy.screen.payment.utils

sealed class CardType(val pattern: String) {
    object Visa : CardType("^4[0-9]{6,}\$")
    object MasterCard :
        CardType("^5[1-5][0-9]{5,}|222[1-9][0-9]{3,}|22[3-9][0-9]{4,}|2[3-6][0-9]{5,}|27[01][0-9]{4,}|2720[0-9]{3,}\$")

    object AmericanExpress : CardType("^3[47][0-9]{5,}\$")
    object DinersClub : CardType("^3(?:0[0-5]|[68][0-9])[0-9]{4,}\$")
    object Discover : CardType("^6(?:011|5[0-9]{2})[0-9]{3,}\$")
    object Jcb : CardType("^(?:2131|1800|35[0-9]{3})[0-9]{3,}\$")
}
