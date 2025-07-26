package ru.netology

fun main() {
    val commission = calcCommission(72_000, "Mastercard", 1_000)
    println("Комиссия: $commission руб.")

}

fun calcCommission (
    amount: Int,
    card: String = "Mir",
    translationsMonth: Int = 0
): Int {
    val orderMaxDay = 150_000
    val orderMaxMonth = 600_000
    val mastercardFreeLimit = 75_000

    if (amount > orderMaxDay || (amount + translationsMonth) > orderMaxMonth) {
        println("Операция заблокирована")
        return 0
    }

    val comMastercard = when {
        translationsMonth < mastercardFreeLimit && (translationsMonth + amount) <= mastercardFreeLimit -> 0
        translationsMonth > mastercardFreeLimit -> ((amount * 0.006).toInt() + 20)
        else -> ((amount - (mastercardFreeLimit - translationsMonth)) * 0.006).toInt() + 20
    }

    val comVisa = if((amount * 0.0075).toInt() > 35) {
        (amount * 0.0075).toInt()
    } else {
        35
    }

    return when (card) {
        "Mastercard" -> comMastercard
        "Visa" -> comVisa
        "Mir" -> 0
        else -> 0
    }
}