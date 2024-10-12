import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _94_binary_tree_inorder_transversal {

    /*
    94. Binary Tree Inorder Traversal
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example 1:
    Input: root = [1,null,2,3]
    Output: [1,3,2]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [1]
    Output: [1]

    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

    Follow up: A recursive solution is trivial, could you do it iteratively?
         */

    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(1, null, 2, 3);
        System.out.println(input1);
        TreeNode root1 = TreeNode.buildTree(input1);
        testInorderTraversal(root1);

        List<Integer> input2 = List.of(); // []
        TreeNode root2 = TreeNode.buildTree(input2);
        testInorderTraversal(root2);
    }

    /**
     * Realiza a travessia "inorder" de uma árvore binária.
     *
     * @param root O nó raiz da árvore binária.
     * @return Uma lista de inteiros representando os valores dos nós na ordem "inorder".
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // Cria uma nova lista para armazenar o resultado da travessia
        inorderTraversalRecursive(root, result); // Chama o metodo recursivo para preencher a lista com os valores dos nós
        return result; // Retorna a lista com os valores dos nós na ordem "inorder"
    }

    /**
     * Metodo auxiliar recursivo para realizar a travessia "inorder" da árvore binária.
     *
     * @param root   O nó atual da árvore binária.
     * @param result A lista onde os valores dos nós serão armazenados.
     */
    private static void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return; // Se o nó atual for nulo, retorna

        inorderTraversalRecursive(root.left, result); // Chama o metodo recursivo para o nó filho da esquerda
        result.add(root.val); // Adiciona o valor do nó atual à lista de resultados
        inorderTraversalRecursive(root.right, result); // Chama o metodo recursivo para o nó filho da direita
    }

    public static void testInorderTraversal(TreeNode root) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        List<Integer> result = inorderTraversal(root);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
