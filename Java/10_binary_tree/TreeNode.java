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
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode modelo) {
        if (modelo == null) throw new IllegalArgumentException("modelo cannot be null");

        this.val = modelo.val;
        this.left = modelo.left == null ? null : (TreeNode) ShallowOrDeepCopy.verifyAndCopy(modelo.left);
        this.right = modelo.right == null ? null : (TreeNode) ShallowOrDeepCopy.verifyAndCopy(modelo.right);
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

        TreeNode that = (TreeNode) obj;

        return Objects.equals(this.val, that.val) &&
                Objects.equals(this.left, that.left) &&
                Objects.equals(this.right, that.right);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + val;
        hash *= prime + (left == null ? 0 : left.hashCode());
        hash *= prime + (right == null ? 0 : right.hashCode());

        return hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(sb, 0, "    ");
        return sb.toString();
    }

    private void buildString(StringBuilder sb, int level, String indent) {
        sb.append(repeatString(indent, level)).append("|-- ").append(val).append("\n");
        if (left != null) left.buildString(sb, level + 1, indent);
        if (right != null) right.buildString(sb, level + 1, indent);
    }

    private String repeatString(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
