import java.util.Objects;

public class ListNode implements Cloneable {

    int val;
    ListNode proximo;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode proximo) {
        this.val = val;
        this.proximo = proximo;
    }

    // Copy constructor
    public ListNode(ListNode molde) {
        if (molde == null) throw new IllegalArgumentException("molde cannot be null");

        this.val = (int) ShallowOrDeepCopy.verifyAndCopy(molde.val);
        this.proximo = (ListNode) ShallowOrDeepCopy.verifyAndCopy(molde.proximo);
    }

    @Override
    public Object clone() {
        ListNode clone = null;

        try {
            clone = new ListNode(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.proximo != null) {
                sb.append(" -> ");
            }
            current = current.proximo;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.val;
        hash *= prime + ((this.proximo == null) ? 0 : this.proximo.hashCode());

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ListNode other = (ListNode) obj;

        return Objects.equals(this.val, other.val) &&
                Objects.equals(this.proximo, other.proximo);
    }
}
