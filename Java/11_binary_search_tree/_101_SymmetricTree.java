import java.util.ArrayList;
import java.util.List;

public class _101_SymmetricTree {
    /*
    101. Symmetric Tree
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Example 1:
    Input: root = [1,2,2,3,4,4,3]
    Output: true

    Example 2:
    Input: root = [1,2,2,null,3,null,3]
    Output: false

    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100
    Follow up: Could you solve it both recursively and iteratively?
     */

    public static void main(String[] args) {
        List<Integer> nodes1 = new ArrayList<>();
        nodes1.add(1);
        nodes1.add(2);
        nodes1.add(2);
        nodes1.add(3);
        nodes1.add(4);
        nodes1.add(4);
        nodes1.add(3);
        TreeNode root1 = TreeNode.buildTree(nodes1);
        testIsSymmetric(root1);

        List<Integer> nodes2 = new ArrayList<>();
        nodes2.add(1);
        nodes2.add(2);
        nodes2.add(2);
        nodes2.add(null);
        nodes2.add(3);
        nodes2.add(null);
        nodes2.add(3);
        TreeNode root2 = TreeNode.buildTree(nodes2);
        testIsSymmetric(root2);
    }

    /**
     * Verifica se uma árvore binária é simétrica em torno de seu centro.
     *
     * @param root o nó raiz da árvore binária
     * @return {@code true} se a árvore for simétrica, {@code false} caso contrário
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * Verifica se duas árvores são imagens espelhadas uma da outra.
     *
     * @param t1 o nó raiz da primeira árvore
     * @param t2 o nó raiz da segunda árvore
     * @return {@code true} se as árvores forem imagens espelhadas, {@code false} caso contrário
     */
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // Se ambos os nós são nulos, eles são espelhados
        if (t1 == null || t2 == null) return false; // Se um dos nós é nulo e o outro não, não são espelhados

        // Verifica se os valores dos nós são iguais e se os subárvores
        // esquerda e direita são espelhadas recursivamente
        return (t1.val == t2.val) &&       // Os valores dos nós são iguais
                isMirror(t1.left, t2.right) && // A subárvore esquerda de t1 é espelhada com a subárvore direita de t2
                isMirror(t1.right, t2.left);   // A subárvore direita de t1 é espelhada com a subárvore esquerda de t2
    }

    public static void testIsSymmetric(TreeNode root) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        boolean result = isSymmetric(root);
        long end = System.nanoTime();

        System.out.println("Output:         " + result);
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}
