package com.example.jetpackcomposeprac

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val keyValue = HashMap<String, String>()
        var name = "name"
        for(c in name){
            name.indexOfFirst { it == c}
            assertEquals(4, 2 + 2)
        }
    }
}