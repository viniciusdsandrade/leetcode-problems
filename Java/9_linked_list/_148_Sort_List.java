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

    public static ListNode sortList(ListNode cabeca) {
        if (cabeca == null || cabeca.next == null) {
            return cabeca;
        }

        // Função para encontrar o nó do meio da lista
        ListNode obterMeio = cabeca;
        ListNode lento = cabeca, rapido = cabeca;
        while (rapido.next != null && rapido.next.next != null) {
            lento = lento.next;
            rapido = rapido.next.next;
        }
        ListNode meio = lento;
        ListNode proximoDoMeio = meio.next;
        meio.next = null;

        // Aplicar a função recursivamente para as duas metades
        ListNode esquerda = sortList(cabeca);
        ListNode direita = sortList(proximoDoMeio);

        // Função para mesclar duas listas ordenadas
        ListNode resultadoDaMesclagem = null;
        ListNode resultado = resultadoDaMesclagem;
        while (esquerda != null && direita != null) {
            if (esquerda.val <= direita.val) {
                if (resultadoDaMesclagem == null) {
                    resultadoDaMesclagem = esquerda;
                    resultado = resultadoDaMesclagem;
                } else {
                    resultadoDaMesclagem.next = esquerda;
                    resultadoDaMesclagem = resultadoDaMesclagem.next;
                }
                esquerda = esquerda.next;
            } else {
                if (resultadoDaMesclagem == null) {
                    resultadoDaMesclagem = direita;
                    resultado = resultadoDaMesclagem;
                } else {
                    resultadoDaMesclagem.next = direita;
                    resultadoDaMesclagem = resultadoDaMesclagem.next;
                }
                direita = direita.next;
            }
        }
        // Se ainda houver elementos em esquerda ou direita, anexá-los ao resultado
        resultadoDaMesclagem.next = (esquerda != null) ? esquerda : direita;

        return resultado;
    }


    public static void testSortList(ListNode head) {
        System.out.println("Input: " + head);
        long start = System.nanoTime();
        ListNode result = sortList(head);
        long end = System.nanoTime();
        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
