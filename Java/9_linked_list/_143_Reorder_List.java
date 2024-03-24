public class _143_Reorder_List {

    public static void main(String[] args) {

        ListNode list1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                );

        ListNode list2 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4)
                                )
                        )
                );

        testReorderList(list1);
        testReorderList(list2);
    }

    public static void testReorderList(ListNode cabeca) {
        System.out.println("Input: " + cabeca);

        long start = System.nanoTime();
        reorderList(cabeca);
        long end = System.nanoTime();

        System.out.println("Output: " + cabeca);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Encontrar o meio da lista
        ListNode lento = head;
        ListNode rapido = head;
        while (rapido != null && rapido.next != null && rapido.next.next != null) {
            lento = lento.next;
            rapido = rapido.next.next;
        }

        // Inverter a segunda metade da lista
        ListNode anterior = null;
        ListNode atual = lento.next;
        while (atual != null) {
            ListNode proximo = atual.next;
            atual.next = anterior;
            anterior = atual;
            atual = proximo;
        }
        lento.next = null; // Dividir a lista ao meio

        // Mesclar as duas metades
        ListNode primeiro = head;
        ListNode segundo = anterior;
        while (segundo != null) {
            ListNode proximoPrimeiro = primeiro.next;
            ListNode proximoSegundo = segundo.next;
            primeiro.next = segundo;
            segundo.next = proximoPrimeiro;
            primeiro = proximoPrimeiro;
            segundo = proximoSegundo;
        }
    }
}