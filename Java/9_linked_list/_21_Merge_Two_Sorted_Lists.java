public class _21_Merge_Two_Sorted_Lists {
    /*
    21. Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists into one sorted list.
    The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
     */

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        testMergeTwoLists(list1, list2);

        ListNode list3 = new ListNode();
        ListNode list4 = new ListNode();
        testMergeTwoLists(list3, list4);

        ListNode list5 = new ListNode();
        ListNode list6 = new ListNode(0);
        testMergeTwoLists(list5, list6);
    }

    public static void testMergeTwoLists(ListNode list1, ListNode list2) {
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        long start = System.nanoTime();
        ListNode result = mergeTwoLists(list1, list2);
        long end = System.nanoTime();

        System.out.println("Result: " + result);
        System.out.println("Execution time: " + (end - start) + "ns");
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode auxiliar = new ListNode(-1);
        ListNode primeiro = auxiliar;

        // Percorre as duas listas enquanto ambas não forem nulas
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                primeiro.next = list1;
                list1 = list1.next; // Avança para o próximo nó na lista1
            } else {
                primeiro.next = list2;
                list2 = list2.next; // Avança para o próximo nó na lista2
            }
            primeiro = primeiro.next; // Move a cabeça da lista mesclada para o nó adicionado
        }

        // Adiciona qualquer nó restante de uma das listas à lista mesclada
        if (list1 != null)
            primeiro.next = list1;
        else
            primeiro.next = list2;

        // Retorna a lista mesclada começando do próximo nó do nó fictício
        return auxiliar.next;
    }
}
