package com.dabler.pinapp.main

import com.dabler.pinapp.calculator.PinCalculator

class MainPresenterImpl(private val pinCalculator: PinCalculator):
    MainPresenter {

    private val minPinLength = 4
    private val pan = "1111222233334444"
    private var mainView: MainView? = null

    override fun attachView(view: MainView) {
        mainView = view
    }

    override fun detachView() {
        mainView = null
    }

    override fun calculatePin(pin: String) {
        if(pin.length >= minPinLength) {
            val calculatedPin = pinCalculator.calculate(pin, pan)
            mainView?.showCalculatedPin(calculatedPin)
        } else {
            mainView?.showPinTooShortError()
        }
    }
}