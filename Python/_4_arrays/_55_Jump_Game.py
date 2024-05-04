import time
from typing import List


# 55. Jump Game
#
#     You are given an integer array nums.
#     You are initially positioned at the array's first index,
#     and each element in the array represents your maximum jump length at that position.
#
#     Return true if you can reach the last index, or false otherwise.
#
#     Example 1:
#     Input: nums = [2,3,1,1,4]
#     Output: true
#     Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
#
# Example 2: Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what.
# Its maximum jump length is 0, which makes it impossible to reach the last index.
#
#     Constraints:
#     1 <= nums.length <= 10^4
#     0 <= nums[i] <= 10^5


class Solution:
    @staticmethod
    def canJump(nums: List[int]) -> bool:
        n = len(nums)
        max_reachable = 0
        for i in range(n):
            if i > max_reachable: return False
            max_reachable = max(max_reachable, i + nums[i])
            if max_reachable >= n - 1: return True
        return False

    @staticmethod
    def canJump2(nums: List[int]) -> bool:
        last_pos = len(nums) - 1

        # Percorra do final para o início
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= last_pos:
                last_pos = i

        return last_pos == 0


def testCanJump(nums: List[int]):
    print("\nInput: ", nums)

    start_time_1 = time.perf_counter_ns()
    res = Solution.canJump(nums)
    end_time_1 = time.perf_counter_ns()

    start_time_2 = time.perf_counter_ns()
    res = Solution.canJump2(nums)
    end_time_2 = time.perf_counter_ns()

    runtime_1 = (end_time_1 - start_time_1)
    runtime_2 = (end_time_2 - start_time_2)

    print(f"Result: {res}")
    print(f"Runtime_1: {runtime_1} ns")
    print(f"Runtime_2: {runtime_2} ns\n")


def main():
    solution = Solution()

    list_1 = [2, 3, 1, 1, 4]
    testCanJump(list_1)

    list_2 = [3, 2, 1, 0, 4]
    testCanJump(list_2)


if __name__ == '__main__':
    main()
