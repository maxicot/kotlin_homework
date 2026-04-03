package org.example

interface CustomList<T> : Iterable<T> {
    operator fun get(index: Int): T
    operator fun set(index: Int, value: T)
    fun add(element: T)
    fun addFirst(element: T)
    fun remove(element: T): Boolean
    fun indexOf(element: T): Int
    val size: Int
}
