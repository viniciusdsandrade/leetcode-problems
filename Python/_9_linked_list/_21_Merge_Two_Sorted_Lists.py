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


#     21. Merge Two Sorted Lists
#     You are given the heads of two sorted linked lists list1 and list2.
#
#     Merge the two lists into one sorted list.
#     The list should be made by splicing together the nodes of the first two lists.
#
#     Return the head of the merged linked list.
#
#     Example 1:
#     Input: list1 = [1,2,4], list2 = [1,3,4]
#     Output: [1,1,2,3,4,4]
#
#     Example 2:
#     Input: list1 = [], list2 = []
#     Output: []
#
#     Example 3:
#     Input: list1 = [], list2 = [0]
#     Output: [0]
#
#     Constraints:
#     The number of nodes in both lists is in the range [0, 50].
#     -100 <= Node.val <= 100
#     Both list1 and list2 are sorted in non-decreasing order.
#      */


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1: return list2
        if not list2: return list1

        if list1.val < list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists(list1, list2.next)
            return list2


def test_merge_two_lists(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    solution = Solution()

    print("\nlist1: ", list1)
    print("list2: ", list2)

    start_time = time.time()
    result = solution.mergeTwoLists(list1, list2)
    end_time = time.time()

    runtime = end_time - start_time
    print("result:", result)
    print(f"Runtime of the program is: {runtime}\n")


def main():
    # Cria uma instância da classe atual
    solution = Solution()

    # Test 1
    list1 = ListNode(1, ListNode(2, ListNode(4)))
    list2 = ListNode(1, ListNode(3, ListNode(4)))
    test_merge_two_lists(list1, list2)

    # Test 2
    list1 = None
    list2 = None
    test_merge_two_lists(list1, list2)

    # Test 3
    list1 = None
    list2 = ListNode(0)
    test_merge_two_lists(list1, list2)


if __name__ == '__main__':
    main()
