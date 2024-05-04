# 3120. Count the Number of Special Characters 1
# You are given a string word.
# A letter is called special if it appears both in lowercase and uppercase in word.
#
# Return the number of special letters in word.
#
# Example 1:
# Input: word = "aaAbcBC"
# Output: 3
# Explanation:
# The special characters in word are 'a', 'b', and 'c'.
#
# Example 2:
# Input: word = "abc"
# Output: 0
# Explanation:
# No character in word appears in uppercase.
#
# Example 3:
# Input: word = "abBCab"
# Output: 1
# Explanation:
# The only special character in word is 'b'.
class Solution:
    @staticmethod
    def numberOfSpecialChars(word: str) -> int:
        """
        This function counts the number of "special characters" in a given string.
        A character is considered special if it appears both in lowercase and uppercase within the string.
        Args:
        word (str): The input string to analyze.
        Returns:
        int: The number of special characters found in the string.
        """

        lower, upper = set(), set()  # Initialize two sets to store lowercase and uppercase letters separately

        for char in word:
            if char.islower():
                lower.add(char)  # Add lowercase letters to the 'lower' set
            else:
                upper.add(char.lower())  # Add the lowercase version of uppercase letters to the 'upper' set

        # Count characters present in both sets (intersection using '&') - these are the special characters
        return len(lower & upper)
