import java.util.Arrays;

public class _2540_MinimuCommonValue {

    /*
    2540. Minimum Common Value

    Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays.
    If there is no common integer amongst nums1 and nums2, return -1.

    Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

    Example 1:
    Input: nums1 = [1,2,3], nums2 = [2,4]
    Output: 2
    Explanation: The smallest element common to both arrays is 2, so we return 2.

    Example 2:
    Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
    Output: 2
    Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.

    Constraints:
    1 <= nums1.length, nums2.length <= 10^5
    1 <= nums1[i], nums2[j] <= 10^9
    Both nums1 and nums2 are sorted in non-decreasing order.
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        testGetCommon(nums1, nums2);

        int[] nums3 = {1, 2, 3, 6};
        int[] nums4 = {2, 3, 4, 5};
        testGetCommon(nums3, nums4);

        int[] nums5 = {1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] nums6 = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        testGetCommon(nums5, nums6);
    }

    /**
     * Encontra o menor valor inteiro comum em dois arrays ordenados.
     *
     * @param nums1 o primeiro array de inteiros, ordenado em ordem não-decrescente
     * @param nums2 o segundo array de inteiros, ordenado em ordem não-decrescente
     * @return o menor valor inteiro comum a ambos os arrays; -1 se não houver valor comum
     */
    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        // Percorre ambos os arrays enquanto os ponteiros estiverem dentro dos limites dos arrays
        while (i < nums1.length && j < nums2.length) {
            // Se os elementos apontados pelos ponteiros forem iguais, retorna
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++; // Se o elemento no 1° array for menor, move o ponteiro do 1° array
            else j++; // Se o elemento no 2° array for menor, move o ponteiro do 2° array
        }

        return -1; // Se não houver elementos comuns, retorna -1
    }

    public static void testGetCommon(int[] nums1, int[] nums2) {
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));

        long start = System.nanoTime();
        int result = getCommon(nums1, nums2);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (end - start) + "ns");
    }
}
