import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _100_SameTree {

    /*
    100. Same Tree
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    Example 1:
    Input: p = [1,2,3], q = [1,2,3]
    Output: true

    Example 2:
    Input: p = [1,2], q = [1,null,2]
    Output: false

    Example 3:
    Input: p = [1,2,1], q = [1,1,2]
    Output: false

    Constraints:
    The number of nodes in both trees is in the range [0, 100].
    -10^4 <= Node.val <= 10^4
     */

    public static void main(String[] args) {
        List<Integer> p1Nodes = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> q1Nodes = new ArrayList<>(Arrays.asList(1, 2, 3));

        TreeNode p1 = TreeNode.buildTree(p1Nodes);
        TreeNode q1 = TreeNode.buildTree(q1Nodes);

        testIsSameTree(p1, q1);

        List<Integer> p2Nodes = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> q2Nodes = new ArrayList<>(Arrays.asList(1, null, 2));

        TreeNode p2 = TreeNode.buildTree(p2Nodes);
        TreeNode q2 = TreeNode.buildTree(q2Nodes);

        testIsSameTree(p2, q2);

        List<Integer> p3Nodes = new ArrayList<>(Arrays.asList(1, 2, 1));
        List<Integer> q3Nodes = new ArrayList<>(Arrays.asList(1, 1, 2));

        TreeNode p3 = TreeNode.buildTree(p3Nodes);
        TreeNode q3 = TreeNode.buildTree(q3Nodes);

        testIsSameTree(p3, q3);
    }

    /**
     * Verifica se duas árvores binárias são idênticas.
     * <p>
     * Duas árvores binárias são consideradas idênticas se forem estruturalmente idênticas
     * e os nós correspondentes nas duas árvores tiverem o mesmo valor.
     *
     * @param p A raiz da primeira árvore binária.
     * @param q A raiz da segunda árvore binária.
     * @return true se as árvores são idênticas, false caso contrário.
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Se ambas as árvores são nulas, então são idênticas
        if (p == null || q == null) return false; // Se uma das árvores é nula e a outra não, então não são idênticas

        if (p.val != q.val) return false; // Se os valores dos nós atuais são diferentes, não são idênticas

        // Recursivamente verificar se as subárvores esquerda e direita são idênticas
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public static void testIsSameTree(TreeNode p, TreeNode q) {
        System.out.println("Input: p = " + p);
        System.out.println("Input: q = " + q);

        long start = System.nanoTime();
        boolean result = isSameTree(p, q);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + "ns\n");
    }
}
