public class _69_sqrtx {
    /*
    69. Sqrt(x)  
    Given a non-negative integer x, return the square root of x 
    rounded down to the nearest integer. The returned integer should be 
    non-negative as well.

    You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 
    Example 1:
    Input: x = 4
    Output: 2
    Explanation: The square root of 4 is 2, so we return 2.
    
    Example 2:
    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 
    Constraints: 
    0 <= x <= 2^31 - 1
     */

    public static void main(String[] args) {
        testMySqrt(4);
        testMySqrt(8);
        testMySqrt(16);
        testMySqrt(25);
        testMySqrt(8388264);
        testMySqrt(16776528);
        testMySqrt(33553056);
        testMySqrt(67106112);
        testMySqrt(134212225);
        testMySqrt(268424450);
        testMySqrt(536848899);
        testMySqrt(1073697799);
        testMySqrt(2147395599);
    }

    public static int mySqrt(int x) {
        // Verifica se o número de entrada é não negativo
        if (x < 0)
            throw new IllegalArgumentException("Input must be non-negative");

        // Retorna diretamente se o número for 0 ou 1
        if (x < 2) return x;

        // Inicializa os limites para a busca binária
        int left = 2;
        int right = x / 2;
        int mid;

        // Inicia a busca binária
        while (left <= right) {
            // Calcula o ponto médio para a busca binária
            mid = left + (right - left) / 2;

            // Verifica se o quadrado do ponto médio é igual a x
            if (mid == x / mid)
                return mid; // Retorna o valor do ponto médio como a raiz quadrada

                // Atualiza os limites da busca com base no resultado da comparação
            else if (mid < x / mid)
                left = mid + 1; // Se o quadrado for menor, atualiza o limite esquerdo
            else
                right = mid - 1; // Se o quadrado for maior, atualiza o limite direito
        }

        // Retorna o valor do limite direito como a resposta
        return right;
    }

    public static int mySqrt2(int x) {
        double p = Math.sqrt(x);
        return (int) p;
    }
    
        /*
            public static int mySqrt(int x) {
                double p= Math.sqrt(x);
                return (int)p;
        }
         */

    public static void testMySqrt(int x) {
        try {
            System.out.println("\nInput:  " + x);
            
            long startTime1 = System.nanoTime();
            int answer1 = mySqrt(x);
            long endTime1 = System.nanoTime();
            
            long startTime2 = System.nanoTime();
            int answer2 = mySqrt2(x);
            long endTime2 = System.nanoTime();
            
            System.out.println("Output: " + answer1);
            System.out.printf("Execution time: %d ns\n", (endTime1 - startTime1));
            System.out.printf("Execution time: %d ns\n", (endTime2 - startTime2));
        } catch (Exception e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }
}