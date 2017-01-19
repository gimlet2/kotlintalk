package com.restmonkeys

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class Slide3 {

    fun getValue(): String? = null

    fun getAndCheck(action: Action) {
        val value = getValue()
        if (value != null) {
            action.doSmth(value)
        }
    }

    fun getAndCheckWithLet(action: Action) {
        getValue().let {
            if (it != null) {
                action.doSmth(it)
            }
        }
    }

    fun getAndCheckWithLetOptionalCall(action: Action) {
        getValue()?.let { action.doSmth(it) }
    }

    @Test
    fun `get and check`() {
        val action: Action = mock()

        getAndCheck(action)
        getAndCheckWithLet(action)
        getAndCheckWithLetOptionalCall(action)

        verify(action, never()).doSmth(any())
    }
}

interface Action {
    fun doSmth(s: String)
}