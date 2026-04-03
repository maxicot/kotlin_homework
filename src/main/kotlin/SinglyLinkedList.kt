package org.example

class SinglyLinkedList<T> : CustomList<T> {
    private class Node<T>(var value: T, var next: Node<T>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var len: Int = 0

    override val size: Int
        get() = this.len

    override fun add(element: T) {
        val new_node = Node(element)

        if (this.tail == null) {
            this.head = new_node
            this.tail = new_node
        } else {
            this.tail!!.next = new_node
            this.tail = new_node
        }

        this.len++
    }

    override fun addFirst(element: T) {
        val new_node = Node(element, this.head)
        this.head = new_node

        if (this.tail == null) {
            this.tail = new_node
        }

        this.len++
    }

    override operator fun get(index: Int): T {
        if (index >= this.len) {
            throw IndexOutOfBoundsException("index: $index, size: ${this.size}")
        }

        var current = this.head

        repeat(index) {
            current = current!!.next
        }

        return current!!.value
    }

    override operator fun set(index: Int, value: T) {
        if (index >= this.len) {
            throw IndexOutOfBoundsException("index: $index, size: ${this.size}")
        }

        var current = this.head

        repeat(index) {
            current = current!!.next
        }

        current!!.value = value
    }

    override fun indexOf(element: T): Int {
        var current = this.head
        var idx = 0

        while (current != null) {
            if (current.value == element) {
                return idx
            }

            current = current.next
            idx++
        }

        return -1
    }

    override fun remove(element: T): Boolean {
        var prev: Node<T>? = null
        var current = this.head

        while (current != null) {
            if (current.value == element) {
                if (prev == null) {
                    this.head = current.next

                    if (this.head == null) {
                        this.tail = null
                    }
                } else {
                    prev.next = current.next

                    if (current == this.tail) {
                        this.tail = prev
                    }
                }

                this.len--
                return true
            }

            prev = current
            current = current.next
        }

        return false
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var current = this@SinglyLinkedList.head
            override fun hasNext(): Boolean = this.current != null

            override fun next(): T {
                val node = this.current ?: throw NoSuchElementException()
                this.current = node.next
                return node.value
            }
        }
    }

    companion object {
        fun<T> singlyLinkedListOf(vararg items: T) =
            items.fold(SinglyLinkedList<T>()) { list, item ->
                list.also { it.add(item) }
            }
    }
}
