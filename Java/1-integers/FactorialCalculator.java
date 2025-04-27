import java.math.BigInteger;
import java.util.function.Function;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class FactorialCalculator {

    public static BigInteger factorialRecursive(int n) {
        if (n <= 1) return ONE;

        return valueOf(n)
                .multiply(factorialRecursive(n - 1));
    }

    public static BigInteger factorialIterative(int n) {
        BigInteger result = ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] valores = {50, 100, 200, 123456};

        for (int n : valores) {
            System.out.println("\n===== Testando fatorial de " + n + " =====");
            runFactorial(n, "iterativo", FactorialCalculator::factorialIterative);
            runFactorial(n, "recursivo", FactorialCalculator::factorialRecursive);
        }
    }

    private static void runFactorial(int n, String label, Function<Integer, BigInteger> method) {
        System.out.print(n + "! (" + label + ") = ");
        long inicio = System.currentTimeMillis();
        try {
            BigInteger resultado = method.apply(n);
            long duracao = System.currentTimeMillis() - inicio;

            String textResult = resultado.toString();
            if (textResult.length() > 100) {
                System.out.println("[Resultado muito grande – " +
                        textResult.length() + " dígitos]");
            } else {
                System.out.println(textResult);
            }

            System.out.println("Tempo de execução: " + duracao + " ms");

        } catch (StackOverflowError e) {
            System.err.println("Stack Overflow! n muito grande para abordagem recursiva.");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
