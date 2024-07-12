import java.util.Arrays;
import java.util.List;

public class _783_MinimumDistanceBetweenBSTNodes {

    /*
    783. Minimum Distance Between BST Nodes
    Given the root of a Binary Search Tree (BST),
    return the minimum difference between the values of any two different nodes in the tree.

    Example 1:
    Input: root = [4,2,6,1,3]
    Output: 1

    Example 2:
    Input: root = [1,0,48,null,null,12,49]
    Output: 1

    Constraints:
    The number of nodes in the tree is in the range [2, 100].
    0 <= Node.val <= 105
     */

    public static void main(String[] args) {
        List<Integer> nodes1 = Arrays.asList(4, 2, 6, 1, 3);
        TreeNode root1 = TreeNode.buildTree(nodes1);

        List<Integer> nodes2 = Arrays.asList(1, 0, 48, null, null, 12, 49);
        TreeNode root2 = TreeNode.buildTree(nodes2);

        testMinDiffInBST(root1);
        testMinDiffInBST(root2);
    }

    public static int minDiffInBST(TreeNode root) {
        return 0;
    }

    public static void testMinDiffInBST(TreeNode root) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        int output = minDiffInBST(root);
        long end = System.nanoTime();

        System.out.println("Output: " + output);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
