package com.dabler.pinapp

import com.dabler.pinapp.calculator.Iso3Calculator
import com.dabler.pinapp.calculator.PinCalculatorImpl
import com.dabler.pinapp.calculator.RandomNumberGenerator
import org.junit.Test

import org.junit.Assert.*

@ExperimentalUnsignedTypes
class PinCalculatorUnitTest {

    val pan = "1111222233334444"
    val pin = "1234"
    val iso3Calculator = Iso3Calculator(MockRandomNumberGenerator())

    @Test
    fun pin_block_calculation_isCorrect() {
        val calc = PinCalculatorImpl(iso3Calculator)
        val result = calc.calculate(pin, pan)
        assertEquals(result, "341226DDDCCCCBBB")
    }

    private class MockRandomNumberGenerator: RandomNumberGenerator {

        override fun getRandString(from: Int, to: Int, size: Int): String {
            return "F".repeat(size)
        }
    }
}