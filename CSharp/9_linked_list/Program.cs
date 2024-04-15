using static _21_Merge_Two_Sorted_Lists;

public class _9_linked_list
{
    public static void Main()
    {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        TestMergeTwoLists(list1, list2);

        var list3 = new ListNode();
        var list4 = new ListNode();
        TestMergeTwoLists(list3, list4);

        var list5 = new ListNode();
        var list6 = new ListNode(0);
        TestMergeTwoLists(list5, list6);
    }
}