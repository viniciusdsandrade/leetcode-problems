public class _110_BalancedBinaryTree {
    /*
    110. Balanced Binary Tree
    Given a binary tree, determine if it is  height-balanced

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: true

    Example 2:
    Input: root = [1,2,2,3,3,null,null,4,4]
    Output: false

    Example 3:
    Input: root = []
    Output: true

    Constraints:
    The number of nodes in the tree is in the range [0, 5000].
    -10^4 <= Node.val <= 10^4
     */

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(new TreeNode(9), 3, new TreeNode(new TreeNode(15), 20, new TreeNode(7)));
        testIsBalanced(root1);

        TreeNode root2 = new TreeNode(new TreeNode(new TreeNode(4), 3, new TreeNode(4)), 2, new TreeNode(new TreeNode(3), 3, null));
        testIsBalanced(root2);

        TreeNode root3 = null;
        testIsBalanced(root3);

        System.out.println("root1.equals(root2) = " + root1.equals(root2));
        System.out.println("root1.hashCode() = " + root1.hashCode());
        System.out.println("root2.hashCode() = " + root2.hashCode());

        TreeNode cloneRoot1 = (TreeNode) root1.clone();
        TreeNode copiaRoot1 = new TreeNode(root1);

        System.out.print("cloneRoot1");
        System.out.println(cloneRoot1);

        System.out.print("copiaRoot1");
        System.out.println(copiaRoot1);

        System.out.println("root1.equals(cloneRoot1) =  " + root1.equals(cloneRoot1));
        System.out.println("root1.equals(copiaRoot1) =  " + root1.equals(copiaRoot1));
        System.out.println("root1.hashCode()         =  " + root1.hashCode());
        System.out.println("cloneRoot1.hashCode()    =  " + cloneRoot1.hashCode());
        System.out.println("copiaRoot1.hashCode()    =  " + copiaRoot1.hashCode());
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    public static int isBalancedHelper(TreeNode root) {
        if (root == null) return 0;

        int left = isBalancedHelper(root.left);
        if (left == -1) return -1;

        int right = isBalancedHelper(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static void testIsBalanced(TreeNode root) {
        System.out.print("Input: ");
        System.out.println(root);

        long start = System.nanoTime();
        boolean result = isBalanced(root);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + "ns");
    }
}
