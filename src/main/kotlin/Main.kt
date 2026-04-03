package org.example

import org.example.SinglyLinkedList.Companion.singlyLinkedListOf

fun main() {
    val t = singlyLinkedListOf(1, 2, 3)
    t[2] = 5
    print(t[2])
}
