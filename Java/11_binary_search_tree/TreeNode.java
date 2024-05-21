import java.util.List;
import java.util.Objects;

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
        this.left = modelo.left == null ? null : (TreeNode) ShallowOrDeepCopy.verifyAndCopy(modelo.left);
        this.right = modelo.right == null ? null : (TreeNode) ShallowOrDeepCopy.verifyAndCopy(modelo.right);
    }

    public static TreeNode buildTree(List<?> nodes) {
        if (nodes == null || nodes.isEmpty()) return null;

        return buildTreeRecursive(nodes, 0);
    }

    private static TreeNode buildTreeRecursive(List<?> nodes, int index) {
        if (index >= nodes.size() || nodes.get(index) == null) return null;

        TreeNode node = new TreeNode((Integer) nodes.get(index));
        node.left = buildTreeRecursive(nodes, 2 * index + 1);
        node.right = buildTreeRecursive(nodes, 2 * index + 2);

        return node;
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
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        TreeNode other = (TreeNode) obj;

        if (val != other.val) return false;

        return (Objects.equals(left, other.left)) &&
                (Objects.equals(right, other.right));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + val;
        hash *= prime + (left == null ? 0 : left.hashCode());
        hash *= prime + (right == null ? 0 : right.hashCode());

        if (hash < 0) hash = ~hash;

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