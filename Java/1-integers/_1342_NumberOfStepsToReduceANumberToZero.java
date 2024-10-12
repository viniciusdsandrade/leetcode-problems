public class _1342_NumberOfStepsToReduceANumberToZero {

    /*
    1342. Number of Steps to Reduce a Number to Zero

    Given an integer num, return the number of steps to reduce it to zero.
    In one step, if the current number is even, you have to divide it by 2,
    otherwise, you have to subtract 1 from it.

    Example 1:
    Input: num = 14
    Output: 6
    Explanation:
    Step 1) 14 is even; divide by 2 and get 7.
    Step 2) 7 is odd; subtract 1 and get 6.
    Step 3) 6 is even; divide by 2 and get 3.
    Step 4) 3 is odd; subtract 1 and get 2.
    Step 5) 2 is even; divide by 2 and get 1.
    Step 6) 1 is odd; subtract 1 and get 0.

    Example 2:
    Input: num = 8
    Output: 4
    Explanation:
    Step 1) 8 is even; divide by 2 and get 4.
    Step 2) 4 is even; divide by 2 and get 2.
    Step 3) 2 is even; divide by 2 and get 1.
    Step 4) 1 is odd; subtract 1 and get 0.

    Example 3:
    Input: num = 123
    Output: 12

    Constraints:
    0 <= num <= 10^6
     */

    public static void main(String[] args) {
        testNumberOfStes(14);
        testNumberOfStes(8);
        testNumberOfStes(123);
    }

    /**
     * Calcula o número de passos necessários para reduzir um número a zero.
     * Em cada passo, se o número for par, ele é dividido por 2.
     * Se o número for ímpar, ele é subtraído por 1.
     *
     * @param num o número a ser reduzido
     * @return o número de passos necessários para reduzir o número a zero
     */
    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0)
                num = num / 2;
            else
                num = num - 1;
            steps++;
        }
        return steps;
    }


    public static void testNumberOfStes(int num) {
        System.out.println("\nInput: num = " + num);

        long startTime = System.nanoTime();
        int result = numberOfSteps(num);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}
