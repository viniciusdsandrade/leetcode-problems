import java.util.List;

public class _2236_RootEqualsSumOfChildren {

    /*
    2236. Root Equals Sum of Children

    You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
    Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.

    Example 1:
    Input: root = [10,4,6]
    Output: true
    Explanation: The values of the root, its left child, and its right child is 10, 4, and 6, respectively.
    10 is equal to 4 + 6, so we return true.

    Example 2:
    Input: root = [5,3,1]
    Output: false
    Explanation: The values of the root, its left child, and its right child are 5, 3, and 1, respectively.
    5 is not equal to 3 + 1, so we return false.

    Constraints:
    The tree consists only of the root, its left child, and its right child.
    -100 <= Node.val <= 100
     */

    public static void main(String[] args) {
        List<Integer> root1 = List.of(10, 4, 6);
        TreeNode tree1 = TreeNode.buildTree(root1);
        testCheckTree(tree1);

        List<Integer> root2 = List.of(5, 3, 1);
        TreeNode tree2 = TreeNode.buildTree(root2);
        testCheckTree(tree2);
    }

    public static boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }

    public static void testCheckTree(TreeNode root) {

        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        boolean result = checkTree(root);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
