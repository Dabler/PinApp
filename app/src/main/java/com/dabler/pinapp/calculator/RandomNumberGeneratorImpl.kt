package com.dabler.pinapp.calculator

import com.dabler.pinapp.extensions.chars
import java.lang.StringBuilder
import kotlin.random.Random

class RandomNumberGeneratorImpl: RandomNumberGenerator {

    override fun getRandString(from: Int, to: Int, size: Int): String {
        val builder = StringBuilder()
        for(i in 0 until size) {
            builder.append(chars[Random.nextInt(from, to)])
        }
        return builder.toString()
    }
}