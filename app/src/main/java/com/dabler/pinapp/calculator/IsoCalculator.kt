package com.dabler.pinapp.calculator

@ExperimentalUnsignedTypes
interface IsoCalculator {

    fun generatePin(pin: String): UByteArray

    fun generatePan(pan: String): UByteArray
}