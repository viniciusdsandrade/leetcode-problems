import java.util.ArrayList;
import java.util.List;

public class _509_FibonacciNumber {

    /*
    509. Fibonacci Number
    The Fibonacci numbers, commonly denoted F(n)
    form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding
    ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).

    Example 1:
    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

    Example 2:
    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

    Example 3:
    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

    Constraints:
    0 <= n <= 30
     */

    public static void main(String[] args) {

        System.out.println(somaSequencia(123L));


        String nome = "Vinícius dos Santos Andrade";
        System.out.println(reverseString(nome));
        System.out.println(reverseString2(nome));
        System.out.println(reverseString3(nome));
        System.out.println(reverseString4(nome));

        for (int i = 0; i <= 1000; i++) {
            System.out.println(isFibonacciNumberString(i));
        }
    }

    public static long fib(long n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static List<Long> generateFirstNFibonacciNumbers(int n) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        for (int i = 2; i < n; i++) {
            sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
        }
        return sequence;
    }

    public static List<Long> generateFibonacciNumbersLessThan(long num) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        int i = 2;
        while (true) {
            long nextNum = sequence.get(i - 1) + sequence.get(i - 2);
            if (nextNum > num) {
                break;
            }
            sequence.add(nextNum);
            i++;
        }
        return sequence;
    }

    public static Long somaSequencia(Long INDICE) {
        long SOMA = 0L, K = 0L;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        return SOMA;
    }

    /*
    5) Escreva um programa que inverta os caracteres de um string.
     */

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }



    public static String reverseString2(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed  = reversed + str.charAt(i);
        }
        return reversed;
    }

    public static String reverseString3(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseString4(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }



    public static String isFibonacciNumberString(long num) {
        return isFibonacciNumber(num) ?
                num + " pertence a sequencia de Fibonacci" :
                num + " não pertence a sequencia de Fibonacci";
    }

    public static boolean isFibonacciNumber(long num) {
        if (num < 0) return false;

        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        int i = 2;
        while (true) {
            long nextNum = sequence.get(i - 1) + sequence.get(i - 2);
            if (nextNum > num) {
                break;
            }
            sequence.add(nextNum);
            i++;
        }
        return sequence.contains(num);
    }

    public static long fib2(long n) {
        if (n <= 1) {
            System.out.println("Fibonacci de " + n + ": " + n);
            return n;
        }

        long[] fib = new long[(int) (n + 1)];
        fib[0] = 0;
        fib[1] = 1;

        System.out.println("Fibonacci de 0: " + fib[0]);
        System.out.println("Fibonacci de 1: " + fib[1]);

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println("Fibonacci de " + i + ": " + fib[i]);
        }

        return fib[(int) n];
    }

    public static void testFib(int n) {
        System.out.println("==============================================================");
        System.out.println("\nInput: " + n);
        long startTime = System.nanoTime();
        //long answer = fib(n);
        long endTime = System.nanoTime();

        long startTime2 = System.nanoTime();
        long answer2 = fib2(n);
        long endTime2 = System.nanoTime();

        long interval1 = endTime - startTime;
        long interval2 = endTime2 - startTime2;

        System.out.println("Output: " + answer2);
        System.out.printf("Recursive time: %.5f ms\n", interval1 / 1_000_000.0);
        System.out.printf("Iterative time: %.5f ms\n", interval2 / 1_000_000.0);
        System.out.printf("Recursivo/Iterativo: %.3f\n", interval1 / (double) interval2);
        System.out.println("==============================================================");
    }
}