package com.restmonkeys

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import kotlin.test.assertEquals

class Slide6 {

    @Test
    fun `testing calls with lambdas`() {
        val a = A(mock())

        whenever(a.b.t(any()))
                .then {
                    val result = (it.arguments[0] as (String) -> String)
                            .invoke("test")
                    assertEquals(result, "test_b")
                }

        a.f()
    }
}

interface B {
    fun t(a: (String) -> String)
}

class A(val b: B) {
    fun f() {
        b.t({ a -> a + "_b" })
    }
}