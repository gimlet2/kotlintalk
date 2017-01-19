package com.restmonkeys

import org.junit.Test
import kotlin.test.assertTrue

class Slide1 {

    @Test
    fun `equals vs ==`() {
        assertTrue { "String".equals("String") }
        assertTrue { "String" == "String" }
        assertTrue { null == null}
        assertTrue { null.equals(null)}
    }
}