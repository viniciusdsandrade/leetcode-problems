import java.util.Arrays;

public class _283_MoveZeroes {

    /*
    283. Move Zeroes
    
    Given an integer array nums, move all 0's to the end of 
    it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    
    Example 2:
    Input: nums = [0]
    Output: [0]
 
    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
 
    Follow up: Could you minimize the total number of operations done?
     */
    public static void main(String[] args) {
        
        int[] nums1 = {0,1,0,3,12};
        testMoveZeroes(nums1);

        int[] nums2 = {0};
        testMoveZeroes(nums2);

        int[] nums3 = {0,0,0,0,0};
        testMoveZeroes(nums3);

        int[] nums4 = {1,2,3,4,5};
        testMoveZeroes(nums4);

        int[] nums5 = {1,0,2,0,3,0,4,0,5};
        testMoveZeroes(nums5);

        int[] nums6 = {1,0,2,0,3,0,4,0,5,0};
        testMoveZeroes(nums6);

        int[] nums7 = {1,0,2,0,3,0,4,0,5,0,0};
        testMoveZeroes(nums7);

        int[] nums8 = {1,0,2,0,3,0,4,0,5,0,0,0};
        testMoveZeroes(nums8);

        int[] nums9 = {1,0,2,0,3,0,4,0,5,0,0,0,0};
        testMoveZeroes(nums9);

        int[] nums10 = {1,0,2,0,3,0,4,0,5,0,0,0,0,0};
        testMoveZeroes(nums10);

        int[] nums11 = {1,0,2,0,3,0,4,0,5,0,0,0,0,0,0};
        testMoveZeroes(nums11);

        int[] nums12 = {1,0,2,0,3,0,4,0,5,0,0,0,0,0,0,0};
        testMoveZeroes(nums12);

        int[] nums13 = {1,0,2,0,3,0,4,0,5,0,0,0,0,0,0,0,0};
        testMoveZeroes(nums13);
    }

    public static void moveZeroes(int[] nums) {
        // Verifica se o array tem apenas um elemento, e se sim, retorna, pois não há nada para fazer.
        if(nums.length == 1) return;

        // Itera sobre o array
        for(int i = 0; i < nums.length; i++) {
            // Verifica se o elemento atual é zero
            if(nums[i] == 0) {
                // Inicializa uma variável j para encontrar o próximo elemento não zero
                int j = i + 1;

                // Enquanto o próximo elemento for zero e não atingir o final do array, avança
                while(j < nums.length && nums[j] == 0) {
                    j++;
                }

                // Se j atingir o final do array, não há mais elementos não zero, então retorna
                if(j == nums.length) return;

                // Troca o elemento atual (zero) pelo próximo elemento não zero encontrado
                nums[i] = nums[j];

                // Atribui zero à posição do próximo elemento não zero
                nums[j] = 0;
            }
        }
    }


    public static void testMoveZeroes(int[] nums) {
        System.out.println("\nInput:  " + Arrays.toString(nums));
        long startTime = System.nanoTime();
        moveZeroes(nums);
        long endTime = System.nanoTime();
        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}