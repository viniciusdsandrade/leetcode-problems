import java.util.List;

import static java.util.Arrays.asList;

public class _897_IncreasingOrderSearchTree {

    /*
    897. Increasing Order Search Tree

    Given the root of a binary search tree, rearrange the tree in in-order so
    that the leftmost node in the tree is now the root of the tree,
    and every node has no left child and only one right child.

    Example 1:
    Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

    Example 2:
    Input: root = [5,1,7]
    Output: [1,null,5,null,7]

    Constraints:
    The number of nodes in the given tree will be in the range [1, 100].
    0 <= Node.val <= 1000
     */

    public static void main(String[] args) {
        // [5,3,6,2,4,null,8,1,null,null,null,7,9]
        TreeNode root1 = TreeNode.buildTree(
                asList(5,
                        List.of(3,
                                List.of(2,
                                        List.of(1)
                                ),
                                List.of(4)
                        ),
                        List.of(6,
                                List.of(8,
                                        List.of(7),
                                        List.of(9)
                                )
                        )
                )
        );

        testIncreasingBST(root1);

        // Input: root = [5,1,7]
        TreeNode root2 = TreeNode.buildTree(
                asList(5,
                        List.of(1),
                        List.of(7)
                )
        );

        testIncreasingBST(root2);
    }

    // Nó fictício que servirá como o nó anterior durante a travessia
    private static TreeNode prev = null;

    /**
     * Rearranja uma árvore binária de busca em ordem crescente para que o nó mais à esquerda
     * na árvore seja agora a raiz da árvore, e cada nó não tenha filho à esquerda e apenas
     * um filho à direita.
     *
     * @param root a raiz da árvore binária de busca
     * @return a nova raiz da árvore reestruturada
     */
    public static TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0); // Um nó fictício para lidar com o caso especial
        prev = dummy; // Inicializa prev para apontar para o nó fictício
        inorderTraversal(root);
        return dummy.right; // A nova raiz real será o filho à direita do nó fictício
    }

    /**
     * Método auxiliar para a travessia em ordem da árvore.
     *
     * @param node o nó atual da árvore
     */
    private static void inorderTraversal(TreeNode node) {
        if (node == null) return;

        // Percorre a subárvore à esquerda
        inorderTraversal(node.left);

        // Processa o nó atual
        node.left = null; // Não queremos nenhum filho à esquerda na nova árvore
        prev.right = node; // O filho à direita de prev se torna o nó atual
        prev = node; // Move prev para o nó atual

        // Percorre a subárvore à direita
        inorderTraversal(node.right);
    }

    public static void testIncreasingBST(TreeNode root) {
        System.out.print("Input: ");
        System.out.println(root);

        long start = System.nanoTime();
        TreeNode result = increasingBST(root);
        long end = System.nanoTime();

        System.out.print("Output: " + result);
        System.out.println("Execution time: " + (end - start) + "ns");
    }
}
