import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187_RepeatedDNASequence {
    
    /*
    187. Repeated DNA Sequences
    The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

    For example, "ACGAATTCCG" is a DNA sequence.
    When studying DNA, it is useful to identify repeated sequences within the DNA.

    Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

    Example 1:
    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    Output: ["AAAAACCCCC","CCCCCAAAAA"]

    Example 2:
    Input: s = "AAAAAAAAAAAAA"
    Output: ["AAAAAAAAAA"]
 
    Constraints:
    1 <= s.length <= 105
    s[i] is either 'A', 'C', 'G', or 'T'.
     */
    
    public static void main(String[] args) {
        testRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        testRepeatedDnaSequences("AAAAAAAAAAAAA");
    }

    private static void testRepeatedDnaSequences(String s) {
        long start = System.nanoTime();
        List<String> result = findRepeatedDnaSequences(s);
        long end = System.nanoTime();

        try {
            printResult(s, result, start, end);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResult(String s, List<String> result, long start, long end) {
        System.out.println("\nInput: " + s);
        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1000000.0);
    }

    // O(n) time complexity
    public static List<String> findRepeatedDnaSequences(String s) {
        
        // Limite de borda
        if (s.length() < 10 || s.length() > 100000) return new ArrayList<>();

        //Para evitar repetição de sequências, usamos um HashSet
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        //Para evitar repetição de sequências, usamos um HashSet
        for (int i = 0; i < s.length() - 9; i++) {
            String ten = s.substring(i, i + 10);

            //Se o conjunto de sequências já tiver a sequência atual, adicionamos ao conjunto de repetidos
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }

        //Retornamos o conjunto de repetidos como uma lista
        return new ArrayList<>(repeated);
    }
}