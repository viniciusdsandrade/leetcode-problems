public class _61_Rotate_List {

    public static void main(String[] args) {

        ListNode head1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));
        int k1 = 2;
        testRotateRight(head1, k1);

        ListNode head2 =
                new ListNode(0,
                        new ListNode(1,
                                new ListNode(2)));
        int k2 = 4;
        testRotateRight(head2, k2);

        ListNode head3 =
                new ListNode(1,
                        new ListNode(2));
        int k3 = 1;
        testRotateRight(head3, k3);

        ListNode head4 =
                new ListNode(1,
                        new ListNode(2));
        int k4 = 2;
        testRotateRight(head4, k4);

        ListNode head5 = new ListNode(1);
        int k5 = 0;
        testRotateRight(head5, k5);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0)
            return head;

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++)
            newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void testRotateRight(ListNode head, int k) {
        System.out.println("\nInput:");
        System.out.println("head: " + head + " k: " + k);

        long start = System.nanoTime();
        ListNode result = rotateRight(head, k);
        long end = System.nanoTime();

        System.out.printf("Output: %s\n", result);
        System.out.printf("Runtime: %d ns\n", (end - start));
        System.out.printf("Runtime: %.3f ms\n", (end - start) / 1e6);
    }
}