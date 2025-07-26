package ru.netology

import org.junit.Assert.*
import org.junit.Test

class MainTest {

    @Test
    fun calcCommission_default() {
        val amount = 30000
        val result = calcCommission(amount)

        assertEquals(0, result)
    }
    @Test
    fun calcCommission_Mastercard() {
        val amount = 300
        val card = "Mastercard"
        val translationsMonth = 1_000

        val result = calcCommission(amount, card, translationsMonth)

        assertEquals(0, result)
    }

    @Test
    fun calcCommission_Mastercard_1() {
        val amount = 30000
        val card = "Mastercard"
        val translationsMonth = 100_000

        val result = calcCommission(amount, card, translationsMonth)

        assertEquals(200, result)
    }

    @Test
    fun calcCommission_Visa() {
        val amount = 1_000
        val card = "Visa"
        val translationsMonth = 1_000

        val result = calcCommission(amount, card, translationsMonth)

        assertEquals(35, result)
    }


    @Test
    fun calcCommission_Visa_1() {
        val amount = 650_000
        val card = "Visa"
        val translationsMonth = 1_000

        val result = calcCommission(amount, card, translationsMonth)

        assertEquals(0, result)
    }


    @Test
    fun calcCommission_Mir() {
        val amount = 1_000
        val card = "Mir"
        val translationsMonth = 100_000

        val result = calcCommission(amount, card, translationsMonth)
        assertEquals(1, result)
    }

}