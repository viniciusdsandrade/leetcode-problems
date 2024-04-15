using System;
using static System.Console;
using static System.DateTime;
using static System.TimeSpan;

public static class _21_Merge_Two_Sorted_Lists
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }

        public override string ToString()
        {
            var sb = new System.Text.StringBuilder();
            sb.Append('[');
            var current = this;
            while (current != null)
            {
                sb.Append(current.val);
                if (current.next != null)
                    sb.Append(" -> ");
                current = current.next;
            }

            sb.Append(']');
            return sb.ToString();
        }
    }

    public static ListNode MergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                current.next = l1;
                l1 = l1.next;
            }
            else
            {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null)
            current.next = l1;
        else
            current.next = l2;

        return dummy.next;
    }

    public static void TestMergeTwoLists(ListNode list1, ListNode list2)
    {
        WriteLine("List 1: " + list1);
        WriteLine("List 2: " + list2);

        var start = Now.Ticks / TicksPerMillisecond;
        ListNode result = MergeTwoLists(list1, list2);
        var end = Now.Ticks / TicksPerMillisecond;

        WriteLine("Result: " + result);
        WriteLine("Execution time: " + (end - start) + "ms");
    }
}