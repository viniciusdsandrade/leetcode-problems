from typing import List
import time


class Solution:
    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            remaining = target - num
            if remaining in seen:
                return [seen[remaining], i]
            seen[num] = i
        return []


    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] + nums[i] == target:
                    return [i, j]

    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            if target - nums[i] in seen:
                return [seen[target - nums[i]], i]
            seen[nums[i]] = i


def test_two_sum(nums: List[int], target: int) -> List[int]:
    solution = Solution()

    print("\nnums: ", nums)
    print("target: ", target)

    start_time = time.time()
    result = solution.twoSum(nums, target)
    end_time = time.time()

    runtime = end_time - start_time
    print("result:", result)
    print(f"Runtime of the program is: {runtime}\n")


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
