import java.util.*;

public class _637_AverageOfLevelsInBinaryTree {

    /*
    637. Average of Levels in Binary Tree
    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
    Answers within 10-5 of the actual answer will be accepted.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [3.00000,14.50000,11.00000]
    Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
    Hence return [3, 14.5, 11].

    Example 2:
    Input: root = [3,9,20,15,7]
    Output: [3.00000,14.50000,11.00000]

    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -2^31 <= Node.val <= 2^31 - 1
     */
    public static void main(String[] args) {
        List<Integer> nodes1 = Arrays.asList(3, 9, 20, null, null, 15, 7);
        TreeNode root1 = TreeNode.buildTree(nodes1);
        testAverageOfLevels(root1);

        List<Integer> nodes2 = Arrays.asList(3, 9, 20, 15, 7);
        TreeNode root2 = TreeNode.buildTree(nodes2);
        testAverageOfLevels(root2);
    }

    /**
     * Calcula a média dos valores dos nós em cada nível de uma árvore binária.
     *
     * @param root A raiz da árvore binária.
     * @return Uma lista contendo a média dos valores dos nós em cada nível.
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        // Fila para processar os nós da árvore
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Processa cada nível da árvore
        while (!queue.isEmpty()) {
            int size = queue.size(); // Número de nós no nível atual
            double sum = 0;

            // Itera sobre todos os nós do nível atual
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                // Adiciona os filhos na fila para processar o próximo nível
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Calcula a média e adiciona ao resultado
            result.add(sum / size);
        }
        return result;
    }

    public static void testAverageOfLevels(TreeNode root) {
        System.out.println("Input: root = " + root);

        long start = System.nanoTime();
        List<Double> result = averageOfLevels(root);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
