import java.util.Arrays;

public class _98_ValidateBinarySearchTree {

    /*
    98. Validate Binary Search Tree
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Example 1:
    Input: root = [2,1,3]
    Output: true

    Example 2:
    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5, but its right child's value is 4.

    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -2^31 <= Node.val <= 2^31 - 1
     */

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.buildTree(Arrays.asList(2, 1, 3));
        testIsValidBST(root1, true);

        TreeNode root2 = TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6));
        testIsValidBST(root2, false);
    }

    /**
     * Verifica se a árvore binária dada é uma árvore binária de busca (BST).
     *
     * @param root a raiz da árvore binária.
     * @return true se a árvore binária for uma BST, false caso contrário.
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * Metodo auxiliar que verifica recursivamente se a árvore binária é uma BST.
     *
     * @param node  o nó atual da árvore binária.
     * @param lower o limite inferior para o valor do nó atual (pode ser null).
     * @param upper o limite superior para o valor do nó atual (pode ser null).
     * @return true se a subárvore com o nó atual for uma BST, false caso contrário.
     */
    private static boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!isValidBST(node.right, val, upper)) return false;
        if (!isValidBST(node.left, lower, val)) return false;

        return true;
    }


    public static void testIsValidBST(TreeNode root, boolean expected) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        boolean result = isValidBST(root);
        long end = System.nanoTime();

        System.out.println("Output:  " + result);
        System.out.println("Expected: " + expected);
        System.out.println("Runtime : " + (end - start) + "ns\n");
    }
}
