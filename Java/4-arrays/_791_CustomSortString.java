import java.util.*;

public class _791_CustomSortString {

    /*
    791. Custom Sort String

    You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
    Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
    Return any permutation of s that satisfies this property.

    Example 1:
    Input:  order = "cba", s = "abcd"
    Output:  "cbad"
    Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
    Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

    Example 2:
    Input:  order = "bcafg", s = "abcd"
    Output:  "bcad"
    Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.
    Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "dbca" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.

    Constraints:
    1 <= order.length <= 26
    1 <= s.length <= 200
    order and s consist of lowercase English letters.
    All the characters of order are unique.
     */

    public static void main(String[] args) {
        String ordem1 = "cba";
        String s1 = "abcd";
        testarOrdenacaoPersonalizada(ordem1, s1);

        String ordem2 = "bcafg";
        String s2 = "abcd";
        testarOrdenacaoPersonalizada(ordem2, s2);
    }

    public static String customSortString(String order, String s) {
        // Mapa para armazenar a prioridade dos caracteres da string 'order'
        Map<Character, Integer> mapaPrioridade = new HashMap<>();

        // Atribui a prioridade baseada na posição de cada caractere em 'order'
        for (int i = 0; i < order.length(); i++) mapaPrioridade.put(order.charAt(i), i);


        StringBuilder resultadoOrdenado = new StringBuilder();// StringBuilder para armazenar os caracteres de 's' que estão em 'order'
        StringBuilder resto = new StringBuilder(); // StringBuilder para armazenar os caracteres de 's' que não estão em 'order'

        // Itera por cada caractere de 's' para separá-los entre os que estão e não estão em 'order'
        for (char c : s.toCharArray()) {
            if (mapaPrioridade.containsKey(c)) {
                resultadoOrdenado.append(c);  // Adiciona o caractere no resultado ordenado
            } else {
                resto.append(c);  // Adiciona os caracteres que não estão em 'order'
            }
        }

        // Ordena os caracteres de 'resultadoOrdenado' conforme o mapa de prioridade
        List<Character> listaOrdenada = new ArrayList<>();
        for (char c : resultadoOrdenado.toString().toCharArray()) {
            listaOrdenada.add(c);
        }

        listaOrdenada.sort(Comparator.comparingInt(mapaPrioridade::get));

        // Converte a lista ordenada de volta para StringBuilder
        resultadoOrdenado.setLength(0);  // Limpa o StringBuilder original
        for (char c : listaOrdenada) resultadoOrdenado.append(c);

        // Adiciona o resto dos caracteres no final (eles podem estar em qualquer posição)
        return resultadoOrdenado + resto.toString();
    }

    public static void testarOrdenacaoPersonalizada(String ordem, String s) {
        System.out.println("Input: ordem = " + ordem + ", s = " + s);

        long inicio, fim, tempoExecucao;
        String resultado;

        inicio = System.nanoTime();
        resultado = customSortString(ordem, s);  // Chamando o metodo com a assinatura correta
        fim = System.nanoTime();

        tempoExecucao = fim - inicio;

        System.out.println("Saída: " + resultado);
        System.out.println("Tempo de Execução: " + tempoExecucao + "ns\n");
    }
}
