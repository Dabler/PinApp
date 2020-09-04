package com.dabler.pinapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.dabler.pinapp.R
import com.dabler.pinapp.calculator.Iso3Calculator
import com.dabler.pinapp.calculator.PinCalculatorImpl
import com.dabler.pinapp.calculator.RandomNumberGeneratorImpl

@ExperimentalUnsignedTypes
class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null
    private lateinit var pinEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializePresenter()
    }

    override fun showCalculatedPin(calculatedPin: String) {
        resultTextView.text = calculatedPin
    }

    override fun showPinTooShortError() {
        Toast.makeText(this, "Pin should have at least 4 digits.", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter = null
        super.onDestroy()
    }

    private fun initializeViews() {
        pinEditText = findViewById(R.id.pin_edit_text)
        calculateButton = findViewById(R.id.calculate_button)
        calculateButton.setOnClickListener { presenter?.calculatePin(pinEditText.text.toString()) }
        resultTextView = findViewById(R.id.result_text_view)
    }

    private fun initializePresenter() {
        val randomNumberGenerator = RandomNumberGeneratorImpl()
        val pinCalculator = PinCalculatorImpl(Iso3Calculator(randomNumberGenerator))
        presenter = MainPresenterImpl(pinCalculator)
        presenter?.attachView(this)
    }
}