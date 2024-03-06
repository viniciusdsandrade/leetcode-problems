public class _203_Remove_Linked_List_Elements {
    /*
    203. Remove Linked List Elements

    Given the head of a linked list and an integer val,
    remove all the nodes of the linked list that has Node.val == val,
    and return the new head.

    Example 1:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]

    Example 2:
    Input: head = [], val = 1
    Output: []

    Example 3:
    Input: head = [7,7,7,7], val = 7
    Output: []

    Constraints:
    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50
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
                        new ListNode(2,
                                new ListNode(6,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)
                                                        )
                                                )
                                        )
                                )
                        )
                );
        testRemoveElements(head1, 6);

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
        testRemoveElements(head2, 1);

        ListNode head3 =
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7,
                                        new ListNode(7)
                                )
                        )
                );
        testRemoveElements(head3, 7);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode atual = dummy;
        while (atual.next != null) {
            System.out.println("\nCurrent node value: " + atual.val);
            if (atual.next.val == val) {
                System.out.println("Removing node with value: " + atual.next.val);
                atual.next = atual.next.next;
            } else {
                System.out.println("Moving to next node");
                atual = atual.next;
            }
        }
        System.out.println("Returning modified list: " + printLinkedList(dummy.next) + "\n");
        return dummy.next;
    }

    public static void testRemoveElements(ListNode head, int val) {
        System.out.println("Input: " + printLinkedList(head));
        System.out.println("val:   " + val);

        long start = System.nanoTime();
        ListNode result = removeElements(head, val);
        long end = System.nanoTime();

        System.out.println("Output: " + printLinkedList(result));
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    public static String printLinkedList(ListNode head) {
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
