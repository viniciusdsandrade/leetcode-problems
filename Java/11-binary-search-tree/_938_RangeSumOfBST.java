import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _938_RangeSumOfBST {

    /*
    938. Range Sum of BST
    Given the root node of a binary search tree and two integers low and high,
    return the sum of values of all nodes with a value in the inclusive range [low, high].

    Example 1:
    Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
    Output: 32
    Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

    Example 2:
    Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
    Output: 23
    Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

    Constraints:
    The number of nodes in the tree is in the range [1, 2 * 104].
    1 <= Node.val <= 10^5
    1 <= low <= high <= 10^5
    All Node.val are unique.
     */

    public static void main(String[] args) {

        List<Integer> nodes1 = Arrays.asList(10, 5, 15, 3, 7, null, 18);
        TreeNode root1 = TreeNode.buildTree(nodes1);
        var low1 = 7;
        var high1 = 15;
        testRangeSumBST(root1, low1, high1);

        List<Integer> nodes2 = Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        TreeNode root2 = TreeNode.buildTree(nodes2);
        var low2 = 6;
        var high2 = 10;
        testRangeSumBST(root2, low2, high2);
    }

    /**
     * Calcula a soma dos valores dos nós de uma árvore binária de busca (BST)
     * que estão dentro do intervalo [low, high].
     *
     * @param root O nó raiz da árvore binária de busca.
     * @param low  O limite inferior do intervalo.
     * @param high O limite superior do intervalo.
     * @return A soma dos valores dos nós dentro do intervalo [low, high].
     */
    public static int rangeSumBST(TreeNode root, int low, int high) {
        // Se o nó atual for nulo, retorna 0.
        if (root == null) return 0;

        // Se o valor do nó atual for menor que o limite inferior,
        // ignora a subárvore esquerda e busca na subárvore direita.
        if (root.val < low) return rangeSumBST(root.right, low, high);

        // Se o valor do nó atual for maior que o limite superior,
        // ignora a subárvore direita e busca na subárvore esquerda.
        if (root.val > high) return rangeSumBST(root.left, low, high);

        // Se o valor do nó atual estiver dentro do intervalo,
        // inclui o valor na soma e continua a busca nas subárvores esquerda e direita.
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void testRangeSumBST(TreeNode root, int low, int high) {
        System.out.println("Input:");
        System.out.println("root = " + root);
        System.out.println("low = " + low);
        System.out.println("high = " + high);

        long start = System.nanoTime();
        int output = rangeSumBST(root, low, high);
        long end = System.nanoTime();

        System.out.println("Output:");
        System.out.println(output);

        System.out.println("Runtime " + (end - start) + "ns");
    }
}
