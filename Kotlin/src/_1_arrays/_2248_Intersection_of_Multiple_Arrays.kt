package _1_arrays

/*
    2248. Intersection of Multiple Arrays
    Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
    return the list of integers that are present in each array of nums sorted in ascending order.

    Example 1:
    Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
    Output: [3,4]
    Explanation:
    The only integers present in each of
    nums[0] = [3,1,2,4,5],
    nums[1] = [1,2,3,4], and
    nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].

    Example 2:
    Input: nums = [[1,2,3],[4,5,6]]
    Output: []
    Explanation:
    There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].

    Constraints:
    1 <= nums.length <= 1000
    1 <= sum(nums[i].length) <= 1000
    1 <= nums[i][j] <= 1000
    All the values of nums[i] are unique.
 */

/**
 * Encontra a interseção de todos os arrays de inteiros em uma lista de arrays.
 *
 * @param nums A lista de arrays de inteiros.
 * @return A lista de inteiros que estão presentes em todos os arrays na lista de entrada.
 *
 * O algoritmo funciona convertendo cada array para um conjunto e usando a operação `intersect` para encontrar a interseção.
 *
 * Exemplo:
 *
 * intersection(arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 3, 4), intArrayOf(3, 4, 5)))
 *
 * retorna [3]
 */
fun intersection(nums: Array<IntArray>): List<Int> {
    if (nums.isEmpty()) return emptyList()

    var commonElements = nums[0].toSet()

    for (i in 1..<nums.size) {
        commonElements = commonElements.intersect(nums[i].toSet())
        if (commonElements.isEmpty()) return emptyList()
    }

    return commonElements.sorted()
}

fun testIntersection(nums: Array<IntArray>) {
    println("\nnums: ${nums.joinToString { it.contentToString() }}")
    val inicio = System.nanoTime()
    val result = intersection(nums)
    val fim = System.nanoTime()

    println("result: $result")
    println("Time: ${fim - inicio}ns")
}

fun main() {

    val nums1 = arrayOf(
        intArrayOf(3, 1, 2, 4, 5),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(3, 4, 5, 6)
    )

    testIntersection(nums1) // [3, 4]

    val nums2 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
    testIntersection(nums2) // []
}