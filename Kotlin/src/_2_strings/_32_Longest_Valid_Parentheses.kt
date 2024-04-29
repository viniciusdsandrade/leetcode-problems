package _2_strings

/*
    32. Longest Valid Parentheses
    Given a string containing just the characters '(' and ')',
    return the length of the longest valid (well-formed) parentheses
    substring.

    Example 1:
    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".

    Example 2:
    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".

    Example 3:
    Input: s = ""
    Output: 0

    Constraints:
    0 <= s.length <= 3 * 104
    s[i] is '(', or ')'.
 */

fun longestValidParentheses(s: String): Int {
    var max = 0
    val dp = IntArray(s.length)
    for (i in 1..<s.length) {
        if (s[i] == ')') {
            if (s[i - 1] == '(') {
                dp[i] = if (i >= 2) dp[i - 2] + 2 else 2
            } else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + if (i - dp[i - 1] >= 2) dp[i - dp[i - 1] - 2] else 0
            }
            max = maxOf(max, dp[i])
        }
    }
    return max
}

fun testLongestValidParentheses(s: String) {
    println("\ns: $s")
    val inicio = System.nanoTime()
    val result = longestValidParentheses(s)
    val fim = System.nanoTime()

    println("result: $result")
    println("Time: ${fim - inicio}ns")
}

fun main() {
    val s1 = "(()"
    val s2 = ")()())"
    val s3 = ""

    testLongestValidParentheses(s1)
    testLongestValidParentheses(s2)
    testLongestValidParentheses(s3)
}
