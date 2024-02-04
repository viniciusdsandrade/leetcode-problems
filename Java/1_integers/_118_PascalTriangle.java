import java.util.ArrayList;
import java.util.List;

public class _118_PascalTriangle {

    /*
    118. Pascal's Triangle
    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly
    above it as shown:

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:
    Input: numRows = 1
    Output: [[1]]

    Constraints:
    1 <= numRows <= 30
     */

    public static void main(String[] args) {
        testGenerate(6);
    }

    public static List<List<Integer>> generate(int numRows) {

        if (numRows < 1 || numRows > 30) {
            throw new IllegalArgumentException("1 <= numRows <= 30");
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(row);
        }

        return result;
    }

    public static void testGenerate(int numRows) {
        System.out.println("Input: " + numRows);

        long startTime = System.nanoTime();
        List<List<Integer>> result = generate(numRows);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n", (endTime - startTime) / 1_000_000.00);
    }
}

