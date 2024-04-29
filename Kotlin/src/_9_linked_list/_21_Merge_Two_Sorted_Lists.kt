package _9_linked_list

class ListNode(var `val`: Int) {

    var next: ListNode? = null

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[")
        var current: ListNode? = this
        while (current != null) {
            sb.append(current.`val`)
            if (current.next != null)
                sb.append(" -> ")
            current = current.next
        }
        sb.append("]")
        return sb.toString()
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var head: ListNode? = null
    var current: ListNode? = null
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            if (head == null) {
                head = l1
                current = head
            } else {
                current?.next = l1
                current = current?.next
            }
            l1 = l1.next
        } else {
            if (head == null) {
                head = l2
                current = head
            } else {
                current?.next = l2
                current = current?.next
            }
            l2 = l2.next
        }
    }

    if (l1 != null)
        current?.next = l1
    else
        current?.next = l2

    return head
}

fun testMergeTwoLists(list1: ListNode?, list2: ListNode?) {
    println("\nlist1: $list1")
    println("list2: $list2")

    val inicio = System.nanoTime()
    val result = mergeTwoLists(list1, list2)
    val fim = System.nanoTime()

    println("Time: ${fim - inicio}")
    println("result: $result")
}

fun createLinkedList(vararg values: Int): ListNode? {
    var head: ListNode? = null
    var tail: ListNode? = null
    for (value in values) {
        val newNode = ListNode(value)
        if (head == null) {
            head = newNode
        } else {
            tail?.next = newNode
        }
        tail = newNode
    }
    return head
}

fun main() {
    val list1 = createLinkedList(1, 2, 4)
    val list2 = createLinkedList(1, 3, 4)

    testMergeTwoLists(list1, list2)
}