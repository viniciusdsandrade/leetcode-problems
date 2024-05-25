# 680. Valid Palindrome II
# Given a string s, return true if the s can be palindrome after deleting
# at most one character from it.
#
# Example 1:
# Input: s = "aba"
# Output: true

# Example 2:
# Input: s = "abca"
# Output: true
# Explanation: You could delete the character 'c'.

# Example 3:
# Input: s = "abc"
# Output: false
#
# Constraints:
# 1 <= s.length <= 10^5
# s consists of lowercase English letters.

class Solution:
    def validPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return (self.is_palindrome(s, l + 1, r) or
                        self.is_palindrome(s, l, r - 1))
            l += 1
            r -= 1
        return True

    @staticmethod
    def is_palindrome(s, left, right):
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True


def test():
    s = "aba"
    print("\nInput: s", s)
    res_1 = Solution().validPalindrome(s)
    print("res_1", res_1)

    s = "abca"
    print("\nInput: s", s)
    res_2 = Solution().validPalindrome(s)
    print("res_2", res_2)

    s = "abc"
    print("\nInput: s", s)
    res_3 = Solution().validPalindrome(s)
    print("res_3", res_3)


def main():
    test()


if __name__ == '__main__':
    main()
