import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _39_Combination_Sum {

    /*
    39. Combination Sum
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
    frequency
     of at least one of the chosen numbers is different.

    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



    Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:
    Input: candidates = [2], target = 1
    Output: []


    Constraints:
    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
     */

    public static void main(String[] args) {
        int[] candidates_1 = new int[]{2, 3, 6, 7};
        int target_1 = 7;

        int[] candidates_2 = new int[]{2, 3, 5};
        int target_2 = 8;

        int[] candidates_3 = new int[]{2};
        int target_3 = 1;

        testCombinationSum(candidates_1, target_1);
        testCombinationSum(candidates_2, target_2);
        testCombinationSum(candidates_3, target_3);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates array
        backtrackCombination(result, new ArrayList<>(), candidates, target, 0); // Call the helper function
        return result;
    }

    private static void backtrackCombination(List<List<Integer>> result,
                                             ArrayList<Integer> combination,
                                             int[] candidates,
                                             int target,
                                             int startIndex) {
        // If the target is less than 0, return
        if (target < 0) return;

        // If the target is 0, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Loop through the candidates array
        for (int start = startIndex; start < candidates.length; start++) {
            combination.add(candidates[start]);   // Add the current candidate to the combination
            backtrackCombination(result, combination, candidates, target - candidates[start], start);            // Call the backtrack function recursively
            combination.removeLast();       // Remove the last element from the combination
        }
    }

    public static void testCombinationSum(int[] candidates, int target) {
        System.out.println("Input: candidates = " + Arrays.toString(candidates) + ", target = " + target);


        long start = System.nanoTime();
        List<List<Integer>> result = combinationSum(candidates, target);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}
