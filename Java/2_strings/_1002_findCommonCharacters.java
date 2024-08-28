import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002_findCommonCharacters {

    public static void main(String[] args) {
        String[] words1 = {"bella", "label", "roller"};
        testCommonsChars(words1);

        String[] words2 = {"cool", "lock", "cook"};
        testCommonsChars(words2);
    }

    /**
     * Encontra os caracteres comuns em todas as strings do array de entrada.
     * <p>
     * A função recebe um array de strings e retorna uma lista de caracteres que
     * aparecem em todas as strings, com a frequência mínima em que aparecem
     * em cada string. Cada caractere é tratado como letra minúscula de 'a' a 'z'.
     *
     * @param words Um array de strings contendo apenas letras minúsculas.
     * @return Uma lista de strings onde cada string contém um caractere comum
     *         presente em todas as strings do array, repetido conforme a
     *         frequência mínima em que aparece em todas as palavras.
     */
    public static List<String> commonChars(String[] words) {
        // Array para armazenar a frequência mínima de cada letra ('a' a 'z')
        int[] commonChars = new int[26];

        // Inicializa o array commonChars com um valor alto (Integer.MAX_VALUE)
        // Isso permite que possamos encontrar a menor frequência de cada caractere
        for (int i = 0; i < 26; i++)
            commonChars[i] = Integer.MAX_VALUE;

        // Percorre cada palavra no array words
        for (String word : words) {
            // Array para contar a frequência de cada letra na palavra atual
            int[] charFrequency = new int[26];

            // Conta a frequência de cada letra na palavra atual
            for (char c : word.toCharArray())
                charFrequency[c - 'a']++;

            // Atualiza commonChars com a menor frequência de cada letra
            // encontrada até agora, para garantir que apenas as letras
            // comuns a todas as palavras serão mantidas
            for (int i = 0; i < 26; i++)
                commonChars[i] = Math.min(commonChars[i], charFrequency[i]);
        }

        // Lista para armazenar o resultado final
        List<String> result = new ArrayList<>();

        // Percorre o array commonChars, adicionando as letras à lista de resultado
        // O número de vezes que cada letra é adicionada corresponde à sua
        // frequência mínima encontrada entre todas as palavras
        for (int i = 0; i < 26; i++) {
            while (commonChars[i]-- > 0)
                result.add(String.valueOf((char) (i + 'a')));
        }

        // Retorna a lista de caracteres comuns
        return result;
    }


    public static void testCommonsChars(String[] words) {
        System.out.println("Input: " + Arrays.toString(words));

        long start = System.nanoTime();
        List<String> result = commonChars(words);
        long end = System.nanoTime();

        long runtime = end - start;

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + " ns");
    }
}
