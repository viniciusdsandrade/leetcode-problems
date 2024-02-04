#include "stdio.h"
#include "stdbool.h"
#include <stdlib.h>
#include <time.h>

/*
    217. Contains Duplicate

    Given an integer array nums, return true if any
    value appears at least twice in the array, and
    return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
 */

int compare(const void *a, const void *b);
bool containsDuplicate(int *nums, int numsSize);
void testContainsDuplicate(int *nums, int numsSize);
void printArray(int *nums, int numsSize);

int main(void) {
    int nums1[] = {1, 2, 3, 1};
    int nums2[] = {1, 2, 3, 4};
    int nums3[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

    testContainsDuplicate(nums1, 4);
    testContainsDuplicate(nums2, 4);
    testContainsDuplicate(nums3, 10);

    return 0;
}

int compare(const void *a, const void *b) {
    return (*(int *) a - *(int *) b);
}

bool containsDuplicate(int *nums, int numsSize) {
    // Ordena o array para facilitar a detecção de duplicatas
    qsort(nums, numsSize, sizeof(int), compare);

    // Verifica se há duplicatas ao percorrer o array
    for (int i = 0; i < numsSize - 1; i++) {
        if (nums[i] == nums[i + 1]) {
            return true; // Encontrou uma duplicata
        }
    }
    return false; // Não encontrou duplicatas
}

void printArray(int *nums, int numsSize) {
    printf("\nInput: [");
    for (int i = 0; i < numsSize; i++) {
        printf("%d", nums[i]);
        if (i < numsSize - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

void testContainsDuplicate(int *nums, int numsSize) {
    printArray(nums, numsSize);

    struct timespec start, end;

    clock_gettime(CLOCK_MONOTONIC, &start);
    bool result = containsDuplicate(nums, numsSize);
    clock_gettime(CLOCK_MONOTONIC, &end);

    double runtimeSeconds = end.tv_sec - start.tv_sec;
    double runtimeNanoseconds = (end.tv_nsec - start.tv_nsec) / 1e6;

    printf("Result: %s\n", result ? "true" : "false");
    printf("Runtime: %.6f milissegundos\n", runtimeSeconds * 1000 + runtimeNanoseconds);
    printf("Runtime: %.3lf ns\n", runtimeNanoseconds * 1000000);
}