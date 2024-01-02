import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class _412_FizzBuzz {
    
    /*
        412. Given an integer 'n', return a String array answer (1-indexed) where:
        - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
        - answer[i] == "Fizz" if i is divisible by 3.
        - answer[i] == "Buzz" if i is divisible by 5.
        - answer[i] == i if none of the above conditions are true.
        
        Example 1:
        Input: n = 3
        Output: ["1","2","Fizz"]
        
        Example 2:
        Input: n = 5
        Output: ["1","2","Fizz","4","Buzz"]
        
        Example 3:
        Input: n = 15
        Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();
            runFizzBuzzTest(n);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runFizzBuzzTest(int n) {
        try {
            long startTime = System.nanoTime();
            List<String> answer = fizzBuzz(n);
            long endTime = System.nanoTime();
            
            System.out.println(answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        if (n < 1)
            return answer;

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                answer.add("FizzBuzz");
            else if (i % 3 == 0)
                answer.add("Fizz");
            else if (i % 5 == 0)
                answer.add("Buzz");
            else
                answer.add(String.valueOf(i));
        }
        return answer;
    }
}