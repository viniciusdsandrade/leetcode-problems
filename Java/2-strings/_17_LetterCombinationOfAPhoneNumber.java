import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.nanoTime;

public class _17_LetterCombinationOfAPhoneNumber {

    /*
    17. Letter Combinations of a Phone Number
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    Return the answer in any order.

    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:

    Input: digits = ""
    Output: []
    Example 3:

    Input: digits = "2"
    Output: ["a","b","c"]

    Constraints:
    0 ≤ digits.length ≤ 4
    digits[i] is a digit in the range ['2', '9'].
     */

    public static void main(String[] ignoredArgs) {
        String digits1 = "23";
        testLetterCombination(digits1);

        String digits2 = "";
        testLetterCombination(digits2);

        String digits3 = "2";
        testLetterCombination(digits3);
    }

    /**
     * Gera todas as combinações possíveis de letras com base nos dígitos fornecidos.
     * Cada dígito de '2' a '9' mapeia para um conjunto de letras, conforme mostrado em um teclado telefônico.
     * O metodo usa uma abordagem de backtracking para explorar todas as possíveis combinações de letras.
     *
     * @param digits Os dígitos fornecidos pelo usuário como uma String. Cada dígito deve estar entre '2' e '9'.
     * @return Uma lista de todas as combinações possíveis de letras.
     */
    public static List<String> letterCombinations(String digits) {

        // Mapeia cada dígito de '2' a '9' para um conjunto de letras, conforme layout do teclado numérico de um telefone.
        Map<Character, String> phoneMap = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );

        // Lista que armazenará todas as combinações possíveis de letras geradas a partir dos dígitos.
        List<String> combinations = new ArrayList<>();

        // Verifica se a entrada é nula ou vazia, caso seja, retorna uma lista vazia, pois não há combinações a gerar.
        if (digits == null || digits.isEmpty()) return combinations;

        // Inicia o processo de backtracking para gerar as combinações. O índice começa em 0 e o caminho é inicialmente vazio.
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());

        return combinations;
    }

    /**
     * Função auxiliar que realiza a geração de combinações de letras usando backtracking.
     * A cada chamada recursiva, a função adiciona uma letra ao caminho atual e prossegue para o próximo dígito.
     * Quando todos os dígitos são processados, a combinação gerada é adicionada à lista de combinações.
     *
     * @param combinations A lista de combinações onde cada combinação final será armazenada.
     * @param phoneMap O mapa que associa cada dígito a suas letras correspondentes.
     * @param digits A String que contém os dígitos a serem processados.
     * @param index O índice atual no processamento dos dígitos.
     * @param path O caminho atual de letras formado a partir dos dígitos processados.
     */
    private static void backtrack(
            List<String> combinations,
            Map<Character, String> phoneMap,
            String digits,
            int index,
            StringBuilder path
    ) {

        // Condição de parada: quando o índice alcança o tamanho da string digits, significa que todas as letras foram combinadas.
        // Nesse ponto, a combinação gerada é adicionada à lista de combinações.
        if (index == digits.length()) {
            combinations.add(path.toString()); // Adiciona o caminho gerado até agora à lista de combinações.
            return; // Retorna para finalizar a chamada recursiva.
        }

        char digit = digits.charAt(index); // Obtém o dígito atual a ser processado com base no índice.
        String letters = phoneMap.get(digit); // Recupera as letras associadas ao dígito atual do mapa.

        // Itera sobre cada letra associada ao dígito atual.
        for (char letter : letters.toCharArray()) {
            path.append(letter); // Adiciona a letra atual ao caminho em construção.
            backtrack(combinations, phoneMap, digits, index + 1, path); // Faz uma chamada recursiva para processar o próximo dígito.
            path.deleteCharAt(path.length() - 1); // Remove a última letra adicionada ao caminho para permitir a exploração de outras combinações.
        }
    }

    public static void testLetterCombination(String digits) {
        System.out.println("\nInput: " + digits);

        List<String> result;
        long start, end, runtime;

        start = nanoTime();
        result = letterCombinations(digits);
        end = nanoTime();

        runtime = end - start;

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
