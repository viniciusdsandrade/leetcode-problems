import java.util.List;

import static java.util.Arrays.asList;

public class _226_Invert_Binary_Tree {
    public static void main(String[] args) {

        // Test 1
        TreeNode root = buildTree(
                asList(4,
                        asList(2,
                                List.of(1),
                                List.of(3)
                        ),
                        asList(7,
                                List.of(6),
                                List.of(9)
                        )
                )
        );
        testInvertTree(root);

        // Test 2
        root = buildTree(
                asList(2,
                        List.of(1),
                        List.of(3)
                )
        );
        testInvertTree(root);

        // Test 3
        root = buildTree(
                asList(1,
                        asList(2,
                                List.of(3),
                                List.of(4)
                        ),
                        asList(5,
                                List.of(6),
                                List.of(7)
                        )
                )
        );
        testInvertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        root.left = invertTree(tempRight);
        root.right = invertTree(tempLeft);

        return root;
    }

    public static void testInvertTree(TreeNode root) {
        System.out.println("-------------------------------------");
        System.out.println("árvore original:");
        System.out.println(root);

        long start = System.nanoTime();
        TreeNode result = invertTree(root);
        long end = System.nanoTime();

        System.out.println("\nárvore invertida:");
        System.out.println(result);
        System.out.println("Execution time: " + (end - start) + "ns");
    }

    @SuppressWarnings("unchecked")
    public static TreeNode buildTree(List<Object> nodes) {
        if (nodes == null || nodes.isEmpty()) return null;

        TreeNode root = new TreeNode((Integer) nodes.get(0));

        if (nodes.size() > 1)
            root.left = buildTree((List<Object>) nodes.get(1));

        if (nodes.size() > 2)
            root.right = buildTree((List<Object>) nodes.get(2));

        return root;
    }
}
