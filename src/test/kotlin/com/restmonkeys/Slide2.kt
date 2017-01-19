package com.restmonkeys

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Slide2 {

    fun getListOfValues(): List<String> {
        val source = listOf("String1", "String2")
        val list = mutableListOf<String>()
        source.forEach {
            list.add(it)
        }
        return list
    }

    @Test
    fun `populate collection`() {
        val list = getListOfValues()
        assertEquals(list.size, 2)
        assertTrue { list[0] == "String1" }
        assertTrue { list[1] == "String2" }
    }

    fun getListOfValuesWithApply(): List<String> {
        val source = listOf("String1", "String2")
        return mutableListOf<String>().apply {
            source.forEach { add(it) }
        }
    }

    @Test
    fun `populate collection with apply`() {
        val list = getListOfValuesWithApply()
        assertEquals(list.size, 2)
        assertTrue { list[0] == "String1" }
        assertTrue { list[1] == "String2" }
    }
}