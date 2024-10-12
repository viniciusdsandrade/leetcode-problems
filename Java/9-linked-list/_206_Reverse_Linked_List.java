public class _206_Reverse_Linked_List {

    /*
    206. Reverse Linked List

    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:
    Input: head = [1,2]
    Output: [2,1]

    Example 3:
    Input: head = []
    Output: []

    Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        testReverseList(head);

        head = new ListNode(1, new ListNode(2));
        testReverseList(head);

        head = new ListNode();
        testReverseList(head);
    }

    /**
     * Inverte a lista ligada dada.
     *
     * @param cabeca a cabeça da lista ligada a ser invertida
     * @return a nova cabeça da lista ligada invertida
     */
    public static ListNode reverseList(ListNode cabeca) {

        ListNode anterior = null; // Declaração do nó anterior como null, pois a nova cauda da lista apontará para null
        ListNode atual = cabeca; // O nó atual é iniciado na cabeça da lista original
        ListNode proximo; // O nó próximo é usado para armazenar temporariamente o próximo nó na iteração

        // Percorre a lista até que o nó atual seja null
        while (atual != null) {
            proximo = atual.next; // Armazena o próximo nó
            atual.next = anterior; // Inverte o ponteiro do nó atual para apontar para o nó anterior
            anterior = atual;  // Avança o nó anterior para o nó atual
            atual = proximo; // Avança o nó atual para o próximo nó
        }

        // Retorna o novo cabeça da lista, que é o nó anterior
        return anterior;
    }

    public static void testReverseList(ListNode head) {
        System.out.println("\nInput:  " + (head));

        long start = System.nanoTime();
        ListNode result = reverseList(head);
        long end = System.nanoTime();

        long diff = end - start;

        System.out.println("Output: " + (result));
        System.out.println("Runtime: " + diff + " ns");
    }
}
