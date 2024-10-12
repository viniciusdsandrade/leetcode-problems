public class _83_Remove_Duplicates_From_Sorted_List {

  /*
  83. Remove Duplicates from Sorted List

    Given the head of a sorted linked list, delete all duplicates such that each
    element appears only once. Return the linked list sorted as well.

    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]
    Example 2:

    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

    Constraints:
    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
   */

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

        ListNode head1 =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2)
                        )
                );
        System.out.println("Input: " + printList(head1));
        ListNode result = deleteDuplicates(head1);

        System.out.println("Output: " + printList(result));


        ListNode head2 =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(3)
                                        )
                                )
                        )
                );
        System.out.println("\nInput: " + printList(head2));
        ListNode result2 = deleteDuplicates(head2);
        System.out.println("Output: " + printList(result2));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode topo = head;
        while (topo != null && topo.next != null) {
            if (topo.val == topo.next.val)
                topo.next = topo.next.next;
            else
                topo = topo.next;

        }
        return head;
    }

    public static void testDeleteDuplicates(ListNode head) {
        System.out.println("Input: head = " + printList(head));

        long start = System.nanoTime();
        ListNode result = deleteDuplicates(head);
        long end = System.nanoTime();

        System.out.println("Output: " + printList(result));
        System.out.printf("Execution Time: %d ns\n", (end - start));
        System.out.printf("Execution Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }


    private static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
