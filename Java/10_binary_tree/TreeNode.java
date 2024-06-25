import java.util.List;

public class TreeNode implements Cloneable {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public TreeNode(TreeNode modelo) {
        if (modelo == null) throw new IllegalArgumentException("modelo cannot be null");

        this.val = modelo.val;
        this.left = modelo.left == null ? null : (TreeNode) ShallowOrDeepCopy2.verifyAndCopy(modelo.left);
        this.right = modelo.right == null ? null : (TreeNode) ShallowOrDeepCopy2.verifyAndCopy(modelo.right);
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

    @Override
    public Object clone() {
        TreeNode clone = null;
        try {
            clone = new TreeNode(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return equals((TreeNode) obj);
    }

    private boolean equals(TreeNode other) {
        // Caso base: se ambos os nós forem nulos, eles são iguais
        if (this == null && other == null) return true;

        // Se um nó for nulo e o outro não, eles não são iguais
        if (other == null) return false;

        // Compare os valores dos nós
        if (val != other.val)
            return false;

        // Compare as subárvores recursivamente
        return equals(left, other.left) && equals(right, other.right);
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        // Caso base: se ambos os nós forem nulos, eles são iguais
        if (node1 == null && node2 == null) return true;

        // Se um nó for nulo e o outro não, eles não são iguais
        if (node1 == null || node2 == null) return false;

        // Compare os valores dos nós
        if (node1.val != node2.val) return false;

        // Compare as subárvores recursivamente
        return equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }

    @Override
    public int hashCode() {
        return hashCode(this);
    }

    private int hashCode(TreeNode node) {
        if (node == null) return 0;

        final int prime = 31;
        int hash = 1;

        hash *= prime + node.val;
        hash *= prime + hashCode(node.left);
        hash *= prime + hashCode(node.right);

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return "\n" + toString(0, this, "", true, new StringBuilder());
    }

    private String toString(int level, TreeNode node, String prefixo, boolean isUltimoFilho, StringBuilder sb) {
        sb.append(prefixo);
        if (level == 0) // Condição para a raiz
            sb.append("[");
        else
            sb.append(isUltimoFilho ? "└─" : "├─").append("[");

        sb.append(node.val).append("]").append("\n");
        String prefixoFilho = prefixo + (isUltimoFilho ? "  " : "│   ");

        if (node.left != null) toString(level + 1, node.left, prefixoFilho, false, sb);
        if (node.right != null) toString(level + 1, node.right, prefixoFilho, true, sb);

        return sb.toString();
    }
}

