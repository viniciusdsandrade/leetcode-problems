# 231. Power of Two
# Given an integer n, return true if it is a power of two. Otherwise, return false.
#
# An integer n is a power of two, if there exists an integer x such that n == 2x.
#
#
#
# Example 1:
# Input: n = 1
# Output: true
# Explanation: 20 = 1

# Example 2:
# Input: n = 16
# Output: true
# Explanation: 24 = 16
# Example 3:

# Input: n = 3
# Output: false

class Solution:
    @staticmethod
    def isPowerOfTwo(n: int) -> bool:
        if n == 0:
            return False
        while n % 2 == 0:
            n = n // 2
        return n == 1


def main():
    n = 1
    print("Input:", n)
    output = Solution.isPowerOfTwo(n)
    print("Output:", output)

    n = 16
    print("\nInput:", n)
    output = Solution.isPowerOfTwo(n)
    print("Output:", output)

    n = 3
    print("\nInput:", n)
    output = Solution.isPowerOfTwo(n)
    print("Output:", output)


if __name__ == "__main__":
    main()
