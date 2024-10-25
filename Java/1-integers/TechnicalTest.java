import java.util.*;

public class TechnicalTest {
    //   1 ,   1 ,   2 , 3 , 5, 8, 13,21....
    // fib1, fib2, answer
    public static int enezimoTermoFibonacciRecursiva(int n) {
        if (n <= 0) throw new InputMismatchException("");
        if (n == 1 || n == 2) return 1;

        return enezimoTermoFibonacciRecursiva(n - 2) +
               enezimoTermoFibonacciRecursiva(n - 1);
    }

    public static int enezimoTermoFibonacciIterativa(int n) {
        if (n <= 0) throw new InputMismatchException("");
//        if (n == 1 || n == 2) return 1;

        int fib1, fib2;
        int answer = 1;

        fib1 = 1;
        fib2 = 1;

        for (int i = 2; i < n; i++) {
            answer = fib1 + fib2;
            fib1 = fib2;
            fib2 = answer;
        }

        return answer;
    }

    // Remover duplicar de um array ordenado in place
    // lista = [1,1,1,2,3,3,3]
    // lista = [1,2,3]
    public static void removeDuplicates(List<Integer> lista) {
        int i = 0;
        while (i < lista.size() - 1) {
            if (Objects.equals(lista.get(i), lista.get(i + 1))) {
                lista.remove(i);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        // Teste para enezimoTermoFibonacciRecursiva
        System.out.println(enezimoTermoFibonacciRecursiva(1)); // Esperado: 1
        System.out.println(enezimoTermoFibonacciRecursiva(2)); // Esperado: 1
        System.out.println(enezimoTermoFibonacciRecursiva(3)); // Esperado: 2
        System.out.println(enezimoTermoFibonacciRecursiva(4)); // Esperado: 3
        System.out.println(enezimoTermoFibonacciRecursiva(5)); // Esperado: 5
        System.out.println(enezimoTermoFibonacciRecursiva(6)); // Esperado: 8

        // Teste para enezimoTermoFibonacciIterativa
        System.out.println(enezimoTermoFibonacciIterativa(1)); // Esperado: 1
        System.out.println(enezimoTermoFibonacciIterativa(2)); // Esperado: 1
        System.out.println(enezimoTermoFibonacciIterativa(3)); // Esperado: 2
        System.out.println(enezimoTermoFibonacciIterativa(4)); // Esperado: 3
        System.out.println(enezimoTermoFibonacciIterativa(5)); // Esperado: 5
        System.out.println(enezimoTermoFibonacciIterativa(6)); // Esperado: 8

        // Teste para removeDuplicates
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 3, 3));
        TechnicalTest.removeDuplicates(list1);
        System.out.println(list1); // Esperado: [1, 2, 3]

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5));
        TechnicalTest.removeDuplicates(list2);
        System.out.println(list2); // Esperado: [1, 2, 3, 4, 5]

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        TechnicalTest.removeDuplicates(list3);
        System.out.println(list3); // Esperado: [1]
    }

}
