import java.util.List;
import java.util.stream.Stream;

public class _700_SearchInABinarySearchTree {
    /*
    700. Search in a Binary Search Tree
    You are given the root of a binary search tree (BST) and an integer val.

    Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

    Input: root = [4,2,7,1,3], val = 2
    Output: [2,1,3]

    Input: root = [4,2,7,1,3], val = 5
    Output: []

    Constraints:
    The number of nodes in the tree is in the range [1, 5000].
    1 <= Node.val <= 10^7
    root is a binary search tree.
    1 <= val <= 10^7
     */

    public static void main(String[] args) {
        List<Object> nodes = List.of(1, 2, 3, 4, 5, 6, 7);
        TreeNode root0 = TreeNode.buildTree(nodes
                .stream()
                .flatMap(o -> o instanceof List ? ((List<?>) o).stream() : Stream.of(o)
                ).toList());
        System.out.println(root0);


        List<Object> nodes1 = List.of(4, 2, 7, 1, 3);
        TreeNode root1 = TreeNode.buildTree(nodes1);
        int val1 = 2;
        testeSearchBST(root1, val1);

        List<Object> nodes2 = List.of(4, 2, 7, 1, 3);
        TreeNode root2 = TreeNode.buildTree(nodes2);
        int val2 = 5;
        testeSearchBST(root2, val2);
    }

    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    private static void testeSearchBST(TreeNode root, int val) {
        System.out.println("Input:");
        System.out.println("root = " + root);
        System.out.println("val = " + val);

        long start = System.nanoTime();
        TreeNode output = searchBST(root, val);
        long end = System.nanoTime();

        System.out.println("Output:");
        System.out.println(output);

        System.out.println("Runtime " + (end - start) + "ns");
    }
}

