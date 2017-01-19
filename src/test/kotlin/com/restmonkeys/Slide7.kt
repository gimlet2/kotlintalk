package com.restmonkeys

import org.junit.Test
import kotlin.reflect.KClass
import kotlin.reflect.primaryConstructor
import kotlin.test.assertEquals

class Slide7 {

    @Test
    fun `reified generics`() {
        val book1 = book {
            user {
                name = "John"
            }
        }

        val book2 = book {
            admin {
                name = "Jack"
            }
        }
        assertEquals(book1.owner.name, "John")
        assertEquals(book2.owner.name, "Jack")
    }
}

operator fun <T : Any> KClass<T>.invoke(): T {
    return this.primaryConstructor!!.callBy(mapOf())
}

abstract class Person(var name: String)
class User(name: String = "<not set>") : Person(name)
class Admin(name: String = "<not set>") : Person(name)

class Book(var owner: Person = User("default"))

fun book(init: Book.() -> Unit): Book {
    return Book().apply { init() }
}

inline fun <reified T : Person> Book.owner(init: T.() -> Unit) {
    owner = createPerson(T::class)
    (owner as T).init()
}

fun <T : Person> createPerson(klass: KClass<T>): Person {
    return klass()
}

fun Book.user(init: User.() -> Unit) {
    owner(init)
}

fun Book.admin(init: Admin.() -> Unit) {
    owner(init)
}