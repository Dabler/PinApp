package com.dabler.pinapp.calculator

import java.lang.StringBuilder
import com.dabler.pinapp.extensions.toUbyteArray

@ExperimentalUnsignedTypes
class Iso3Calculator(private val randomNumberGenerator: RandomNumberGenerator): IsoCalculator {

    override fun generatePin(pin: String): UByteArray {
        val adjustedPin = StringBuilder()
            .append("3")
            .append(pin.length)
            .append(pin)
            .append(randomNumberGenerator.getRandString(0,15, 14-pin.length))
            .toString()
        return adjustedPin.toUbyteArray()
    }

    override fun generatePan(pan: String): UByteArray {
        val adjustedPan = StringBuilder()
            .append("0000")
            .append(pan.takeLast(13))
            .dropLast(1)
            .toString()
        return adjustedPan.toUbyteArray()
    }
}