public class _148_Sort_List {
    public static void main(String[] args) {

        ListNode list1 =
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(3)
                                )
                        )
                );

        ListNode list2 =
                new ListNode(-1,
                        new ListNode(5,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(0)
                                        )
                                )
                        )
                );


        ListNode list3 = new ListNode(0, null);

        testSortList(list1);
        testSortList(list2);
        testSortList(list3);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode rightHead = middle.next;

        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) current.next = left;
        if (right != null) current.next = right;

        return dummy.next;
    }


    public static void testSortList(ListNode head) {
        System.out.println("\nInput: " + head);
        long start = System.nanoTime();
        ListNode result = sortList(head);
        long end = System.nanoTime();
        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
