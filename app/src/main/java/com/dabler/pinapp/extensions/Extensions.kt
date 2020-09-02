package com.dabler.pinapp.extensions

import java.lang.StringBuilder
import kotlin.math.ceil

val chars = charArrayOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')

@ExperimentalUnsignedTypes
fun UByteArray.xor(array: UByteArray): UByteArray {
    val xorArray = UByteArray(this.size)
    for(i in this.indices) {
        xorArray[i] = this[i].xor(array[i])
    }
    return xorArray
}

@ExperimentalUnsignedTypes
fun UByteArray.toHexString(): String {
    val builder = StringBuilder()
    for (element in this) {
        builder.append(chars[element.getHiNibbleValue().toInt()])
        builder.append(chars[element.getLowNibbleValue().toInt()])
    }
    return builder.toString()
}

@ExperimentalUnsignedTypes
fun setHiNibbleValue(value: Int): UByte = (0xF0 and (value shl 4)).toUByte()

@ExperimentalUnsignedTypes
fun setLowNibbleValue(value: Int): UByte = (0x0F and value).toUByte()

@ExperimentalUnsignedTypes
fun UByte.getHiNibbleValue(): UByte = this.toInt().ushr(4).toUByte()

@ExperimentalUnsignedTypes
fun UByte.getLowNibbleValue(): UByte = (this and 15u).toUByte()

@ExperimentalUnsignedTypes
fun String.toUbyteArray(): UByteArray {
    val size = ceil(this.length.toDouble()/2.toDouble()).toInt()
    val arr = UByteArray(size)
    var index = 0
    for (i in 0 until size) {
        arr[i] = setHiNibbleValue(chars.indexOf(this[index])) or setLowNibbleValue(chars.indexOf(this[index+1]))
        index += 2
    }
    return arr
}