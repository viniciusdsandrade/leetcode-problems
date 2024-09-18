import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Arrays.asList;


public class _819_MostCommonWord {

    public static void main(String[] args) {
        String paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned1 = {"hit"};
        testMostCommonWord(paragraph1, banned1);

        String paragraph2 = "a.";
        String[] banned2 = {};
        testMostCommonWord(paragraph2, banned2);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        String[] bannedWords = new String[banned.length];

        int maxCount, count;

        for (int i = 0; i < banned.length; i++) {
            bannedWords[i] = banned[i].toLowerCase();
        }

        maxCount = 0;
        String mostCommonWord = "";
        for (String word : words) {
            if (!asList(bannedWords).contains(word)) {
                count = 0;
                for (String w : words) {
                    if (word.equals(w)) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    mostCommonWord = word;
                }
            }
        }

        return mostCommonWord;
    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        // 1. Limpeza e divisão do parágrafo em palavras minúsculas.
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");

        // 2. Criação de um HashSet para armazenar as palavras banidas (busca mais rápida).
        HashSet<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        // 3. Contagem da frequência de cada palavra utilizando um HashMap.
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // 4. Encontrar a palavra mais frequente.
        String mostCommonWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }

        return mostCommonWord;
    }

    public static void testMostCommonWord(String paragraph, String[] banned) {
        System.out.println("\nInput: paragraph = " + paragraph);
        System.out.println("Input: banned = " + Arrays.toString(banned));

        long startTime1, endTime1, startTime2, endTime2, runtime1, runtime2;
        String result1, result2, formattedRatio;
        double speedRatio;

        startTime1 = System.nanoTime();
        result1 = mostCommonWord(paragraph, banned);
        endTime1 = System.nanoTime();

        startTime2 = System.nanoTime();
        result2 = mostCommonWord2(paragraph, banned);
        endTime2 = System.nanoTime();

        runtime1 = endTime1 - startTime1;
        runtime2 = endTime2 - startTime2;

        System.out.println("Output1: " + result1);
        System.out.println("Output2: " + result2);

        System.out.println("Runtime1: " + runtime1 + " ns");
        System.out.println("Runtime2: " + runtime2 + " ns");

        // Aplicando a máscara com 3 casas decimais
        speedRatio = runtime1 / (double) runtime2;
        formattedRatio = format("%.3f", speedRatio);

        System.out.println("Runtime2 is " + formattedRatio + " times faster than Runtime1");
    }
}
