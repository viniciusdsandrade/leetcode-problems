import time
from typing import List


# 1512. Number of Good Pairs
# Given an array of integers nums, return the number of good pairs.
# A pair (i, j) is called good if nums[i] == nums[j] and i < j.

# Example 1:
# Input: nums = [1,2,3,1,1,3]
# Output: 4
# Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

# Example 2:
# Input: nums = [1,1,1,1]
# Output: 6
# Explanation: Each pair in the array are good.

# Example 3:
# Input: nums = [1,2,3]
# Output: 0
#
# Constraints:
# 1 <= nums.length <= 100
# 1 <= nums[i] <= 100

class Solution:
    @staticmethod
    def numIdenticalPairs(nums: List[int]) -> int:
        """
                Optimized version of numIdenticalPairs2 using a single loop and in-place counting.

                Args:
                    nums: A list of integers.

                Returns:
                    The number of good pairs in the list.
                """

        good_pairs = 0
        count = {}  # Frequency dictionary

        for num in nums:
            if num in count:
                good_pairs += count[num]  # Add existing count to good_pairs
                count[num] += 1  # Increment count
            else:
                count[num] = 1  # Initialize count

        return good_pairs

    @staticmethod
    def numIdenticalPairs2(nums: List[int]) -> int:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        good_pairs = sum(f * (f - 1) // 2 for f in freq.values())
        return good_pairs


def testNumIdenticalPairs(nums: List[int]):
    print("\nInput: ", nums)

    start_time_1 = time.perf_counter_ns()
    res = Solution.numIdenticalPairs(nums)
    end_time_1 = time.perf_counter_ns()

    start_time_2 = time.perf_counter_ns()
    res2 = Solution.numIdenticalPairs2(nums)
    end_time_2 = time.perf_counter_ns()

    runtime_1 = (end_time_1 - start_time_1)
    runtime_2 = (end_time_2 - start_time_2)

    print(f"Result: {res}")
    print(f"Runtime_1: {runtime_1} ns")
    print(f"Runtime_1: {runtime_2} ns\n")


def main():
    solution = Solution()

    list_1 = [1, 2, 3, 1, 1, 3]
    testNumIdenticalPairs(list_1)

    list_2 = [1, 1, 1, 1]
    testNumIdenticalPairs(list_2)

    list_3 = [1, 2, 3]
    testNumIdenticalPairs(list_3)


if __name__ == '__main__':
    main()
