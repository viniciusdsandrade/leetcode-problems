import static java.lang.Math.max;
import static java.lang.String.valueOf;

public class _451_SortCharactersByFrequency {

    /*
    451. Sort Characters By Frequency

    Given a string s, sort it in decreasing order based on the frequency of the characters.
    The frequency of a character is the number of times it appears in the string.

    Return the sorted string. If there are multiple answers, return any of them.

    Example 1:
    Input: s = "tree"
    Output: "eert"
    Explanation: 'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    Example 2:
    Input: s = "cccaaa"
    Output: "aaaccc"
    Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
    Note that "cacaca" is incorrect, as the same characters must be together.

    Example 3:
    Input: s = "Aabb"
    Output: "bbAa"
    Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
     */

    public static void main(String[] ignoredArgs) {
        String s1 = "tree";
        testFrequencySort(s1);

        String s2 = "cccaaa";
        testFrequencySort(s2);

        String s3 = "Aabb";
        testFrequencySort(s3);
    }

    /**
     * Reordena os caracteres de uma string com base na frequência de ocorrência de cada caractere,
     * de modo que os caracteres mais frequentes apareçam primeiro. Se dois caracteres tiverem a mesma
     * frequência, a ordem relativa entre eles não importa.
     *
     * @param s A string de entrada a ser reordenada.
     * @return Uma nova string com os caracteres reordenados conforme a frequência de ocorrência.
     * @throws NullPointerException Se a string de entrada for nula.
     */
    public static String frequencySort(String s) {
        // Array para armazenar a frequência de cada caractere.
        // O tamanho 128 cobre todos os caracteres ASCII.
        int[] freq = new int[128];

        // Loop através da string, convertendo cada caractere em seu valor ASCII e incrementando a frequência
        // Incrementa a contagem de ocorrências para o caractere atual
        for (char c : s.toCharArray()) freq[c]++;

        // StringBuilder é usado para construir a nova string de forma eficiente.
        StringBuilder sb = new StringBuilder();

        // Este laço continuará até que o comprimento da string construída seja igual ao da string original.
        while (sb.length() < s.length()) {
            int max = 0; // Variável para rastrear a maior frequência encontrada.
            char c = 0;  // Variável para armazenar o caractere associado à maior frequência.

            // Itera por todas as frequências de caracteres para encontrar o mais frequente ainda não processado.
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > max) {  // Se a frequência do caractere atual for maior que a máxima encontrada
                    max = freq[i];    // Atualiza o valor máximo
                    c = (char) i;     // Atualiza o caractere associado ao valor máximo
                }
            }

            // Adiciona o caractere ao StringBuilder, repetindo-o com base em sua frequência.
            // A função 'valueOf(c).repeat(max)' cria uma string com o caractere repetido 'max' vezes.
            sb.append(valueOf(c).repeat(max(0, max)));

            freq[c] = 0; // Redefine a frequência do caractere processado para zero, garantindo que ele não seja processado novamente.
        }

        return sb.toString(); // Retorna a string construída com os caracteres ordenados por frequência.
    }


    public static void testFrequencySort(String s) {
        System.out.println("Input: s = " + s);

        String result;
        long start, end, time;

        start = System.nanoTime();
        result = frequencySort(s);
        end = System.nanoTime();

        time = end - start;

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + time + " ns");
    }
}
