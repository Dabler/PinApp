package com.dabler.pinapp.main

interface MainView {

    fun showCalculatedPin(calculatedPin: String)

    fun showPinTooShortError()
}