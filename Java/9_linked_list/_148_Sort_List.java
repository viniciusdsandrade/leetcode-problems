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
        if (cabeca == null || cabeca.proximo == null) {
            return cabeca;
        }

        // Função para encontrar o nó do meio da lista
        ListNode obterMeio = cabeca;
        ListNode lento = cabeca, rapido = cabeca;
        while (rapido.proximo != null && rapido.proximo.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }
        ListNode meio = lento;
        ListNode proximoDoMeio = meio.proximo;
        meio.proximo = null;

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
                    resultadoDaMesclagem.proximo = esquerda;
                    resultadoDaMesclagem = resultadoDaMesclagem.proximo;
                }
                esquerda = esquerda.proximo;
            } else {
                if (resultadoDaMesclagem == null) {
                    resultadoDaMesclagem = direita;
                    resultado = resultadoDaMesclagem;
                } else {
                    resultadoDaMesclagem.proximo = direita;
                    resultadoDaMesclagem = resultadoDaMesclagem.proximo;
                }
                direita = direita.proximo;
            }
        }
        // Se ainda houver elementos em esquerda ou direita, anexá-los ao resultado
        resultadoDaMesclagem.proximo = (esquerda != null) ? esquerda : direita;

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
