public class _234_Palindrome_Linked_List {

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

    public static boolean isPalindrome(ListNode cabeca) {
        // 'lento' e 'rapido' são ponteiros para percorrer a lista
        ListNode lento = cabeca;
        ListNode rapido = cabeca;

        // Avança 'lento' em um nó e 'rapido' em dois nós por vez
        // Quando 'rapido' chegar ao fim da lista, 'lento' estará no meio
        while (rapido != null && rapido.next != null) {
            lento = lento.next;
            rapido = rapido.next.next;
        }

        // Inverte a segunda metade da lista
        ListNode anterior = null;
        while (lento != null) {
            ListNode proximo = lento.next;
            lento.next = anterior;
            anterior = lento;
            lento = proximo;
        }

        // Compara a primeira metade da lista com a segunda metade invertida
        // Se algum valor não corresponder, a lista não é um palíndromo
        while (anterior != null) {
            if (cabeca.val != anterior.val) {
                return false;
            }
            cabeca = cabeca.next;
            anterior = anterior.next;
        }

        // Se todos os valores corresponderem, a lista é um palíndromo
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