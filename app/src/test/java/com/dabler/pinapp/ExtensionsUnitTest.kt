package com.dabler.pinapp

import com.dabler.pinapp.extensions.*
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

@ExperimentalUnsignedTypes
class ExtensionsUnitTest {

    @Test
    fun xor_return_correct_value() {
        val array1 = ubyteArrayOf(12.toUByte(), 4.toUByte())
        val array2 = ubyteArrayOf(4.toUByte(), 12.toUByte())
        val result = array1.xor(array2).toByteArray()
        Assert.assertArrayEquals(result, ubyteArrayOf(8.toUByte(), 8.toUByte()).toByteArray())
    }

    @Test
    fun toHexString_return_correct_value() {
        val array = ubyteArrayOf(17.toUByte(), 17.toUByte())
        val result = array.toHexString()
        assertEquals(result, "1111")
    }

    @Test
    fun setHiNibbleValue_return_correct_value() {
        val result = setHiNibbleValue(1)
        assertEquals(result, 16.toUByte())
    }

    @Test
    fun setLowNibbleValue_return_correct_value() {
        val result = setLowNibbleValue(1)
        assertEquals(result, 1.toUByte())
    }

    @Test
    fun getHiNibbleValue_return_correct_value() {
        val result = 17.toUByte().getHiNibbleValue()
        assertEquals(result, 1.toUByte())
    }

    @Test
    fun getLowNibbleValue_return_correct_value() {
        val result = 17.toUByte().getLowNibbleValue()
        assertEquals(result, 1.toUByte())
    }

    @Test
    fun toUbyteArray_return_correct_value() {
        val result = "1F".toUbyteArray()
        Assert.assertArrayEquals(result.toByteArray(), ubyteArrayOf(31.toUByte()).toByteArray())
    }
}