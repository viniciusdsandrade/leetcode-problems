public class _19_Remove_Nth_Node_From_End_of_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        /*
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
        Example 2:

        Input: head = [1], n = 1
        Output: []
        Example 3:

        Input: head = [1,2], n = 1
        Output: [1]
         */

        ListNode head1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                );
        int n1 = 2;

        ListNode head2 = new ListNode(1);
        int n2 = 1;

        ListNode head3 =
                new ListNode(1,
                        new ListNode(2)
                );
        int n3 = 1;

        testRemoveNthFromEnd(head1, n1);
        testRemoveNthFromEnd(head2, n2);
        testRemoveNthFromEnd(head3, n3);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static void testRemoveNthFromEnd(ListNode head, int n) {
        long start = System.nanoTime();
        ListNode result = removeNthFromEnd(head, n);
        long end = System.nanoTime();

        System.out.print("Output: ");
        printListNode(result);
        System.out.println("\nTime: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
        System.out.println();
    }

    public static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) {
                sb.append(" -> ");
            }
        }

        sb.append("]");
        System.out.println(sb);
    }

}

