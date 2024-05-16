import java.util.List;

import static java.util.Arrays.asList;

public class _226_InvertBinaryTree {
    public static void main(String[] args) {

        // Test 1
        TreeNode root = TreeNode.buildTree(
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
        root = TreeNode.buildTree(
                asList(2,
                        List.of(1),
                        List.of(3)
                )
        );
        testInvertTree(root);

        // Test 3
        root = TreeNode.buildTree(
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

        root = TreeNode.buildTree(
                asList(1,
                        asList(2,
                                List.of(3),
                                asList(4,
                                        asList(5,
                                                asList(6,
                                                        asList(7,
                                                                asList(8,
                                                                        asList(9,
                                                                                asList(10,
                                                                                        asList(11,
                                                                                                asList(12,
                                                                                                        asList(13,
                                                                                                                asList(14,
                                                                                                                        List.of(15)
                                                                                                                )
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        asList(5,
                                List.of(6),
                                asList(7,
                                        List.of(8),
                                        asList(9,
                                                List.of(10),
                                                asList(11,
                                                        List.of(12),
                                                        asList(13,
                                                                List.of(14),
                                                                List.of(15)
                                                        )
                                                )
                                        )
                                )
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
}
