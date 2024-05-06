# 234. Palindrome Linked List
# Given the head of a singly linked list, return true if it is a
# palindrome or false otherwise.
import time
from typing import Optional


# Example 1:
# Input: head = [1,2,2,1]
# Output: true

# Example 2:
# Input: head = [1,2]
# Output: false
#
# Constraints:
# The number of nodes in the list is in the range [1, 105].
# 0 <= Node.val <= 9
#
#
# Follow up: Could you do it in O(n) time and O(1) space?


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
    def isPalindrome(head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True

        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        while slow:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node

        while prev:
            if prev.val != head.val:
                return False
            prev = prev.next
            head = head.next

        return True


def test_is_palindrome(head: Optional[ListNode]):
    solution = Solution()

    print("head: ")
    print(head)

    start_time_1 = time.perf_counter_ns()
    result = solution.isPalindrome(head)
    end_time_1 = time.perf_counter_ns()

    print("result: ")
    print(result)
    print(f"Runtime: {end_time_1 - start_time_1}ns\n")


def main():
    solution = Solution()

    # Test 1
    head = ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    test_is_palindrome(head)

    # Test 2
    head = ListNode(1, ListNode(2))
    test_is_palindrome(head)

    # Test 3
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(1)))))
    test_is_palindrome(head)


if __name__ == '__main__':
    main()
