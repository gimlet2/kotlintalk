package com.restmonkeys

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Slide5 {

    @Test
    fun `infix functions`() {
        val helloName = "Hello" to "world"
        assertTrue { helloName is HelloName }
        assertEquals(helloName.hello, "Hello")
        assertEquals(helloName.name, "world")
        println(helloName)
    }
}

data class HelloName(val hello: String, val name: String)

infix fun String.to(that: String) = HelloName(this, that)