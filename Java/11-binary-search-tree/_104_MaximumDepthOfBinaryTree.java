import java.util.Arrays;

public class _104_MaximumDepthOfBinaryTree {
    /*
    104. Maximum Depth of Binary Tree
    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3

    Example 2:
    Input: root = [1,null,2]
    Output: 2

    Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
     */

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        testMaxDepth(root1);

        TreeNode root2 = TreeNode.buildTree(Arrays.asList(1, null, 2));
        testMaxDepth(root2);

        TreeNode root3 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        testMaxDepth(root3);

        TreeNode root4 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        testMaxDepth(root4);

        TreeNode root5 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        testMaxDepth(root5);
    }

    /**
     * Calcula a profundidade máxima de uma árvore binária.
     *
     * <p>Esta função determina a profundidade máxima de uma árvore binária utilizando
     * um metodo recursivo. A profundidade de uma árvore é o número de nós ao longo do
     * caminho mais longo desde a raiz até a folha mais distante. Se a árvore estiver vazia,
     * a profundidade será 0.</p>
     *
     * @param root o nó raiz da árvore binária. Pode ser {@code null} para representar uma árvore vazia.
     * @return a profundidade máxima da árvore binária.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // A profundidade máxima da árvore é o maior valor entre as profundidades das subárvores
        // esquerda e direita, somado a 1 (que representa a raiz atual)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void testMaxDepth(TreeNode root) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        int output = maxDepth(root);
        long end = System.nanoTime();

        long runtime = end - start;

        System.out.println("Output: " + output);
        System.out.println("Runtime: " + runtime + "ns\n");
    }
}
