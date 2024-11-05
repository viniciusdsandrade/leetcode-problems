import java.util.HashMap;
import java.util.Map;

import static java.lang.System.nanoTime;

public class _13_roman_to_integer {

    /*
    13. Roman to Integer
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII. Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
     The same principle applies to the number nine, which is written as IX.
     There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    Example 1:
    Input: s = "III"
    Output: 3
    Explanation: III = 3.

    Example 2:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */

    public static void main(String[] ignoredArgs) {
        String first = "III";
        String second = "LVIII";
        String third = "MCMXCIV";

        testRomanToInt(first);
        testRomanToInt(second);
        testRomanToInt(third);
    }

    /// Converte um numeral romano para um número inteiro.
    /// Esse metodo percorre cada caractere na string, aplicando as regras dos numerais
    /// romanos para converter o valor correspondente.
    ///
    /// O numeral romano é analisado caractere por caractere. Em casos onde dois
    /// caracteres formam uma combinação especial, como "IV" ou "IX", esses valores
    /// são somados diretamente.
    ///
    /// @param s a string que contém o numeral romano a ser convertido
    /// @return o valor inteiro correspondente ao numeral romano fornecido
    public static int romanToInt(String s) {
        int n = s.length(); // comprimento da string
        int answer = 0; // inicializa o total da soma

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i); // obtém o caractere atual

            // Verifica se o caractere atual é 'I'
            if (c == 'I') {
                // Verifica se o próximo caractere é 'V' para representar "IV"
                if (i + 1 < n && s.charAt(i + 1) == 'V') {
                    answer += 4;
                    i++; // pula para o próximo caractere, pois já usou 'V'
                } else if (i + 1 < n && s.charAt(i + 1) == 'X') {
                    answer += 9; // representa "IX"
                    i++; // pula para o próximo caractere
                } else {
                    answer += 1; // caso contrário, é apenas 'I'
                }
            } else if (c == 'V') {
                answer += 5; // valor simples para 'V'
            } else if (c == 'X') {
                if (i + 1 < n && s.charAt(i + 1) == 'L') {
                    answer += 40; // representa "XL"
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'C') {
                    answer += 90; // representa "XC"
                    i++;
                } else {
                    answer += 10; // caso contrário, é apenas 'X'
                }
            } else if (c == 'L') {
                answer += 50; // valor simples para 'L'
            } else if (c == 'C') {
                if (i + 1 < n && s.charAt(i + 1) == 'D') {
                    answer += 400; // representa "CD"
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'M') {
                    answer += 900; // representa "CM"
                    i++;
                } else {
                    answer += 100; // caso contrário, é apenas 'C'
                }
            } else if (c == 'D') {
                answer += 500; // valor simples para 'D'
            } else if (c == 'M') {
                answer += 1000; // valor simples para 'M'
            }
        }

        return answer; // retorna o valor final
    }

    /// Converte um numeral romano para um número inteiro utilizando um mapeamento para os
    /// valores dos numerais. Esse metodo permite tanto símbolos de um caractere quanto combinações
    /// de dois caracteres.
    ///
    /// O mapa facilita a conversão de pares específicos, como "IV" e "IX", ao invés de verificar
    /// cada combinação manualmente no código.
    ///
    /// @param s a string contendo o numeral romano a ser convertido
    /// @return o valor inteiro correspondente ao numeral romano fornecido
    public static int romanToInt2(String s) {
        // Mapeia os valores romanos para inteiros
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);

        int i = 0;
        int n = s.length(); // comprimento da string
        int result = 0; // inicializa o resultado final

        // Itera sobre cada caractere na string
        while (i < n) {
            // Tenta obter o símbolo de dois caracteres
            if (i + 1 < n) {
                String twoChar = s.substring(i, i + 2); // símbolo de dois caracteres
                // Verifica se o símbolo de dois caracteres está no mapa
                if (romanMap.containsKey(twoChar)) {
                    result += romanMap.get(twoChar); // adiciona o valor correspondente
                    i += 2; // pula dois caracteres
                    continue; // vai para a próxima iteração
                }
            }
            // Obtém o símbolo de um caractere
            String oneChar = s.substring(i, i + 1);
            result += romanMap.get(oneChar); // adiciona o valor de um caractere
            i++; // avança para o próximo caractere
        }

        return result; // retorna o valor final
    }


    public static void testRomanToInt(String s) {
        System.out.println("\nInput: " + s);

        long start1, end1, runtime1;
        long start2, end2, runtime2;
        int answer1, answer2;
        double ratio;

        // Número de iterações para obter uma média mais precisa
        int iterations = 1_000_000;

        // Medição para versão 1
        start1 = nanoTime();
        answer1 = 0;
        for (int i = 0; i < iterations; i++) answer1 = romanToInt(s);
        end1 = nanoTime();


        // Medição para versão 2
        start2 = nanoTime();
        answer2 = 0;
        for (int i = 0; i < iterations; i++) answer2 = romanToInt2(s);
        end2 = nanoTime();

        runtime1 = end1 - start1;
        runtime2 = end2 - start2;

        // Cálculo da razão
        ratio = (double) runtime2 / runtime1;

        // Exibição dos resultados
        System.out.println("Output1:  " + answer1);
        System.out.println("Runtime1: " + runtime1 + " ns");
        System.out.println("Output2:  " + answer2);
        System.out.println("Runtime2: " + runtime2 + " ns");
        System.out.printf("Runtime2/Runtime1: %.2f%n", ratio);
        if (ratio > 1) {
            System.out.printf("Versão 1 é aproximadamente %.2f vezes mais rápida que a Versão 2.%n", ratio);
        } else {
            System.out.printf("Versão 2 é aproximadamente %.2f vezes mais rápida que a Versão 1.%n", 1 / ratio);
        }
    }
}
