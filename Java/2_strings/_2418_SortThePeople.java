import java.util.Arrays;

public class _2418_SortThePeople {

    /*
    2418. Sort the People
    You are given an array of strings names, and an array heights that consists of
    distinct positive integers. Both arrays are of length n.

    For each index i, names[i] and heights[i] denote the name and height of the ith person.

    Return names sorted in descending order by the people's heights.

    Example 1:
    Input: names = ["Mary","John","Emma"], heights = [180,165,170]
    Output: ["Mary","Emma","John"]
    Explanation: Mary is the tallest, followed by Emma and John.
    Example 2:

    Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
    Output: ["Bob","Alice","Bob"]
    Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

    Constraints:
    n == names.length == heights.length
    1 <= n <= 103
    1 <= names[i].length <= 20
    1 <= heights[i] <= 105
    names[i] consists of lower and upper case English letters.
    All the values of heights are distinct.
     */

    public static void main(String[] args) {
        String[] names1 = {"Mary", "John", "Emma"};
        int[] heights1 = {180, 165, 170};
        testSortPeople(names1, heights1);

        String[] names2 = {"Alice", "Bob", "Bob"};
        int[] heights2 = {155, 185, 150};
        testSortPeople(names2, heights2);
    }

    public static void testSortPeople(String[] names, int[] heights) {
        System.out.println("Input: names = " + Arrays.toString(names) + ", heights = " + Arrays.toString(heights));

        long startTime = System.nanoTime();
        String[] result = sortPeople(names, heights);
        long endTime = System.nanoTime();

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
    }

    /**
     * Ordena um array de nomes de pessoas com base em suas alturas em ordem decrescente.
     *
     * @param names um array de Strings contendo os nomes das pessoas
     * @param heights um array de inteiros contendo as alturas das pessoas
     * @return um array de Strings contendo os nomes das pessoas ordenados de acordo com suas alturas em ordem decrescente
     */
    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] result = new String[n];
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (heights[j] == sortedHeights[n - i - 1]) {
                    result[i] = names[j];
                    break;
                }
            }
        }

        return result;
    }
}
