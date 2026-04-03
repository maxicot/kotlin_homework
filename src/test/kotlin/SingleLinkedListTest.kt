import org.example.SinglyLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SinglyLinkedListTest {
    private lateinit var list: SinglyLinkedList<Int>

    @BeforeEach
    fun setUp() {
        list = SinglyLinkedList<Int>()
    }

    @Test
    fun `add elements`() {
        list.add(1)
        list.add(2)
        list.add(3)

        assertEquals(3, list.size)
        for (i in list.withIndex()) {
            assertEquals(i.index + 1, i.value)
        }
    }

    @Test
    fun `addFirst works correctly`() {
        list.add(2)
        list.addFirst(1)

        assertEquals(1, list[0])
        assertEquals(2, list[1])
    }

    @Test
    fun `added elements are properly ordered`() {
        list.add(1)
        list.add(2)
        list.addFirst(0)
        list.add(3)

        assertEquals(list[0], 0)
        assertEquals(list[1], 1)
        assertEquals(list[2], 2)
        assertEquals(list[3], 3)
    }

    @Test
    fun `remove element`() {
        list.add(1)
        list.add(2)
        list.add(3)

        assertTrue(list.remove(2))
        assertEquals(2, list.size)
        assertEquals(1, list[0])
        assertEquals(3, list[1])
    }

    @Test
    fun `remove non-existing element`() {
        list.add(1)
        list.add(2)

        val removed = list.remove(3)
        assertFalse(removed)
        assertEquals(2, list.size)
    }

    @Test
    fun `contains works`() {
        list.add(1)
        list.add(2)

        assertTrue(list.contains(1))
        assertFalse(list.contains(3))
    }

    @Test
    fun `removed isn't contained`() {
        list.add(1)
        list.add(2)
        list.remove(1)

        assertFalse(list.contains(1))
        assertTrue(list.contains(2))
    }

    @Test
    fun `get by index`() {
        list.add(10)
        list.add(20)
        list.add(30)

        assertEquals(10, list[0])
        assertEquals(20, list[1])
        assertEquals(30, list[2])
    }

    @Test
    fun `removed can't be indexed`() {
        list.add(0)
        list.add(1)
        list.remove(1)

        assertThrows(IndexOutOfBoundsException::class.java) {
            list[1]
        }
    }

    @Test
    fun `get throws exception on invalid index`() {
        list.add(10)
        list[0]

        assertThrows(IndexOutOfBoundsException::class.java) {
            list[5]
        }
    }

    @Test
    fun `indexOf works`() {
        list.add(10)
        list.add(20)
        list.add(30)

        assertEquals(2, list.indexOf(20))
    }

    @Test
    fun `removed can't be found`() {
        list.add(0)
        list.remove(0)

        assertEquals(list.indexOf(0), -1)
    }

    @Test
    fun `set works`() {
        list.add(10)
        list.add(20)
        list.add(30)

        list[2] = 5
        assertEquals(5, list[2])
    }

    @Test
    fun `iteration works`() {
        list.add(1)
        list.add(2)
        list.add(3)

        assertEquals(list.iterator().toList().toIntArray(), [1, 2, 3])
    }
}
