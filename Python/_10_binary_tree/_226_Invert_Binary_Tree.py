from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self, level=0, indent="    "):
        s = level*indent + "|-- " + repr(self.val) + "\n"
        if self.left:
            s += self.left.__str__(level+1)
        if self.right:
            s += self.right.__str__(level+1)
        return s


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return None

        temp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(temp)

        return root


def test_invert_tree(root: Optional[TreeNode]):
    solution = Solution()

    print("\nroot: ")
    print(root)
    result = solution.invertTree(root)

    print("\nresult: ")
    print(result)


def build_tree(nodes):
    if not nodes:
        return None
    root = TreeNode(nodes[0])
    if len(nodes) > 1:
        root.left = build_tree(nodes[1])
    if len(nodes) > 2:
        root.right = build_tree(nodes[2])
    return root


def main():
    solution = Solution()

    # Test 1
    root = build_tree([4, [2, [1], [3]], [7, [6], [9]]])
    test_invert_tree(root)

    # Test 2
    root = build_tree([2, [1], [3]])
    test_invert_tree(root)


if __name__ == '__main__':
    main()
