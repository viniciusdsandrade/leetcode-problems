public class ListNode implements Cloneable {

    public int val;
    public ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Copy constructor
    public ListNode(ListNode modelo) {
        if (modelo == null) throw new IllegalArgumentException("modelo cannot be null");

        this.val = modelo.val;
        if (modelo.next != null)
            this.next = new ListNode(modelo.next);
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
            if (current.next != null)
                sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
