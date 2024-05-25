from typing import List
import time


class Solution:
    @staticmethod
    def twoSum1(nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            remaining = target - num
            if remaining in seen:
                return [seen[remaining], i]
            seen[num] = i
        return []

    @staticmethod
    def twoSum2(nums: List[int], target: int) -> List[int]:

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] + nums[i] == target:
                    return [i, j]

    @staticmethod
    def twoSum3(nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            if target - nums[i] in seen:
                return [seen[target - nums[i]], i]
            seen[nums[i]] = i


def test_two_sum(nums: List[int], target: int) -> List[int]:
    solution = Solution()

    print("\nnums: ", nums)
    print("target: ", target)

    start_time_1 = time.perf_counter_ns()
    result = solution.twoSum1(nums, target)
    end_time_1 = time.perf_counter_ns()

    start_time_2 = time.perf_counter_ns()
    result = solution.twoSum2(nums, target)
    end_time_2 = time.perf_counter_ns()

    start_time_3 = time.perf_counter_ns()
    result = solution.twoSum3(nums, target)
    end_time_3 = time.perf_counter_ns()

    runtime_1 = end_time_1 - start_time_1
    runtime_2 = end_time_2 - start_time_2
    runtime_3 = end_time_3 - start_time_3
    print("result:", result)
    print(f"Runtime_1:  {runtime_1}ns")
    print(f"Runtime_2:  {runtime_2}ns")
    print(f"Runtime_3:  {runtime_3}ns")


def main():
    solution = Solution()

    # Test 1
    nums = [2, 7, 11, 15]
    target = 9
    test_two_sum(nums, target)

    # Test 2
    nums = [3, 2, 4]
    target = 6
    test_two_sum(nums, target)

    # Test 3
    nums = [3, 3]
    target = 6
    test_two_sum(nums, target)


if __name__ == '__main__':
    main()
