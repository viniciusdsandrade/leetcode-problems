import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _993_CousinsInBinaryTree {

    /*
    993. Cousins in Binary Tree
    Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
    return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.
    Note that in a binary tree, the root node is at the depth 0,
    and children of each depth k node are at the depth k + 1.

    Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

    Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

    Example 3:
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

    Constraints:
    The number of nodes in the tree is in the range [2, 100].
    1 <= Node.val <= 100
    Each node has a unique value.
    x != y
    x and y are exist in the tree.
     */

    public static void main(String[] args) {
        List<Integer> nodes1 = Arrays.asList(1, 2, 3, 4);
        TreeNode root1 = TreeNode.buildTree(nodes1);

        List<Integer> nodes2 = Arrays.asList(1, 2, 3, null, 4, null, 5);
        TreeNode root2 = TreeNode.buildTree(nodes2);

        List<Integer> nodes3 = Arrays.asList(1, 2, 3, null, 4);
        TreeNode root3 = TreeNode.buildTree(nodes3);

        testIsCousins(root1, 4, 3);
        testIsCousins(root2, 5, 4);
        testIsCousins(root3, 2, 3);
    }

    /**
     * Verifica se dois nós em uma árvore binária são primos. Dois nós são considerados primos
     * se estiverem no mesmo nível da árvore, mas tiverem pais diferentes.
     *
     * @param root A raiz da árvore binária.
     * @param x Valor do primeiro nó a ser verificado.
     * @param y Valor do segundo nó a ser verificado.
     * @return {@code true} se os nós forem primos; {@code false} caso contrário.
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXFound = false;
            boolean isYFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Verifica se os filhos do nó atual são x e y
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                            (current.left.val == y && current.right.val == x)) {
                        return false;
                    }
                }

                // Verifica se encontramos x ou y neste nível
                if (current.val == x) isXFound = true;
                if (current.val == y) isYFound = true;

                // Adiciona os filhos à fila
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // Se ambos x e y foram encontrados no mesmo nível, retorna true
            if (isXFound && isYFound) return true;

            // Se apenas um deles foi encontrado, retorna false
            if (isXFound || isYFound) return false;
        }

        return false;
    }


    public static void testIsCousins(TreeNode root, int x, int y) {
        System.out.println("Input: " + root);

        long start = System.nanoTime();
        boolean result = isCousins(root, x, y);
        long end = System.nanoTime();

        long runtime = end - start;

        System.out.println("Output:  " + result);
        System.out.println("Runtime: " + runtime + " ns");
    }
}
