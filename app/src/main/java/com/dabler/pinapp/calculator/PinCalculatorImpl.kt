package com.dabler.pinapp.calculator

import com.dabler.pinapp.extensions.toHexString
import com.dabler.pinapp.extensions.xor

@ExperimentalUnsignedTypes
class PinCalculatorImpl(private val isoCalculator: IsoCalculator): PinCalculator {

    override fun calculate(pin: String, pan: String): String {
        val newPin = isoCalculator.generatePin(pin)
        val newPan = isoCalculator.generatePan(pan)
        val xorArray = newPin.xor(newPan)
        return xorArray.toHexString()
    }
}