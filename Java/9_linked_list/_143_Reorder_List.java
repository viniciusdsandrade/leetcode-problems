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

    public static void reorderList(ListNode cabeca) {
        if (cabeca == null || cabeca.proximo == null) {
            return;
        }

        // Encontrar o meio da lista
        ListNode lento = cabeca;
        ListNode rapido = cabeca;
        while (rapido != null && rapido.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }

        // Inverter a segunda metade da lista
        ListNode anterior = null;
        while (lento != null) {
            ListNode proximo = lento.proximo;
            lento.proximo = anterior;
            anterior = lento;
            lento = proximo;
        }

        // Mesclar as duas metades
        ListNode primeiro = cabeca;
        ListNode segundo = anterior;
        while (segundo.proximo != null) {
            ListNode proximoPrimeiro = primeiro.proximo;
            ListNode proximoSegundo = segundo.proximo;
            primeiro.proximo = segundo;
            segundo.proximo = proximoPrimeiro;
            primeiro = proximoPrimeiro;
            segundo = proximoSegundo;
        }
    }
}
