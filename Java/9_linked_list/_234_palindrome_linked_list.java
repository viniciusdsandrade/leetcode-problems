public class _234_palindrome_linked_list {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1)
                        )
                )
        );
        testIsPalindrome(head);

        ListNode head_2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)
                                )
                        )
                )
        );
        testIsPalindrome(head_2);

        ListNode head_3 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)
                                )
                        )
                )
        );
        testIsPalindrome(head_3);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

    public static void testIsPalindrome(ListNode head) {

        System.out.println("Input: " + head);

        long start = System.nanoTime();
        boolean result = isPalindrome(head);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}