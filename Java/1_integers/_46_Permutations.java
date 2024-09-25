import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permutations {

    /*
    46. Permutations

    Given an array nums of distinct integers, return all the possible
    permutations.
    You can return the answer in any order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]

    Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        testPermute(nums1);

        int[] nums2 = {0, 1};
        testPermute(nums2);

        int[] nums3 = {1};
        testPermute(nums3);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(result, current, nums, visited);

        return result;
    }

    private static void backtrack(List<List<Integer>> result,
                                  List<Integer> current,
                                  int[] nums,
                                  boolean[] visited) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, visited);
            current.removeLast();
            visited[i] = false;
        }
    }

    public static void testPermute(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        List<List<Integer>> result;
        long start, end, runtime;

        start = System.nanoTime();
        result = permute(nums);
        end = System.nanoTime();

        runtime = end - start;

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + "ns\n");
    }
}
