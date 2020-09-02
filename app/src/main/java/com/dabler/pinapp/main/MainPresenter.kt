package com.dabler.pinapp.main

interface MainPresenter {

    fun attachView(view: MainView)

    fun detachView()

    fun calculatePin(pin: String)
}