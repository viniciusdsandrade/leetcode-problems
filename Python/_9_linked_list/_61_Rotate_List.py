import time
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        if self is None:
            return "[]"
        result = "["
        node = self
        while node is not None:
            result += str(node.val)
            if node.next is not None:
                result += " -> "
            node = node.next
        result += "]"
        return result


class Solution:
    @staticmethod
    def rotateRight(head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head: return None

        length = 1
        tail = head
        while tail.next:
            length += 1
            tail = tail.next
        tail.next = head

        k %= length
        if k:
            for _ in range(length - k):
                tail = tail.next

        new_head = tail.next
        tail.next = None

        return new_head


def test_rotate_right(head: Optional[ListNode], k: int):
    solution = Solution()

    print("head: ")
    print(head)
    print(f"k: {k}")

    start_time_1 = time.perf_counter_ns()
    result = solution.rotateRight(head, k)
    end_time_1 = time.perf_counter_ns()

    print("result: ")
    print(result)
    print(f"Runtime: {end_time_1 - start_time_1}ns\n")


def main():
    solution = Solution()

    # Test 1
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    k = 2
    test_rotate_right(head, k)

    # Test 2
    head = ListNode(0, ListNode(1, ListNode(2)))
    k = 4
    test_rotate_right(head, k)

    # Test 3
    head = None
    k = 0
    test_rotate_right(head, k)


if __name__ == '__main__':
    main()
