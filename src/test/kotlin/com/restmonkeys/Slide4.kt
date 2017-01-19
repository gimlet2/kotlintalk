package com.restmonkeys

import org.junit.Test
import kotlin.test.assertEquals

class Slide4 {

    @Test
    fun `extention functions`() {
        val result = listOf<String>().ifEmpty { listOf("Value") }
        assertEquals(result.size, 1)
        assertEquals(result[0], "Value")
    }
}

fun <T : Collection<*>> T.ifEmpty(invoke: () -> T): T =
        if (this.isEmpty()) invoke() else this

