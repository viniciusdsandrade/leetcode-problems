import time
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self, level=0, indent="    "):
        s = level * indent + "|-- " + repr(self.val) + "\n"
        if self.left:
            s += self.left.__str__(level + 1)
        if self.right:
            s += self.right.__str__(level + 1)
        return s


def build_tree(nodes):
    if not nodes or isinstance(nodes, int):  # Base case: empty list or single integer
        return None if not nodes else TreeNode(nodes)  # Return None or a leaf node

    root = TreeNode(nodes[0])
    if len(nodes) > 1 and isinstance(nodes[1], list):  # Check for left child (list)
        root.left = build_tree(nodes[1])
    if len(nodes) > 2 and isinstance(nodes[2], list):  # Check for right child (list)
        root.right = build_tree(nodes[2])
    return root


class Solution:

    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return None

        temp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(temp)

        return root


def test_invert_tree(root: Optional[TreeNode]):
    solution = Solution()

    print("root: ")
    print(root)

    start_time_1 = time.perf_counter_ns()
    result = solution.invertTree(root)
    end_time_1 = time.perf_counter_ns()

    print("result: ")
    print(result)
    print(f"Runtime: {end_time_1 - start_time_1}ns\n")


def main():
    solution = Solution()

    # Test 1
    root = build_tree([4, [2, [1], [3]], [7, [6], [9]]])
    test_invert_tree(root)

    # Test 2
    root = build_tree([2, [1], [3]])
    test_invert_tree(root)

    # Test 3
    root = build_tree([1, [2, [3, [4], [5, [6], [7]]], 1, [2, 3, 4, 5], 6, 7]])
    test_invert_tree(root)

    # Test 4
    root = build_tree([1, [2, [3, [4], [5, [6], [7, [8], [9]]]], [10, [11, [12], [13]], [14, [15], [16]]]]])
    test_invert_tree(root)

    root = build_tree([1, [2, [3, [4], [5, [6], [7, [8], [9, 10, 11], 12], 13], 14],
                           [15, [16, [17], [18], 19], [20, 21, 22, 23], 24], 25],
                       [26, [27, 28, 29, 30], [31, 32, 33, 34], 35]])
    test_invert_tree(root)


if __name__ == '__main__':
    main()
