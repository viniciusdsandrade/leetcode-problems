package main

import (
	"fmt"
	"time"
)

/*
136. Single Number
Given a non-empty array of integers nums,
every element appears twice except for one.
Find that single one.

You must implement a solution with a linear runtime complexity
and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/
func singleNumber(nums []int) int {
	result := 0
	for _, num := range nums {
		result ^= num
	}
	return result
}

func testSingleNumber(nums []int) {
	fmt.Println("List:  ", nums)

	start := time.Now()
	result := singleNumber(nums)
	elapsed := time.Since(start)

	fmt.Println("Result: ", result)
	fmt.Printf("Execution time: %d nanoseconds\n", elapsed.Nanoseconds()) // Modificação aqui
}

func main() {
	list1 := []int{2, 2, 1}
	testSingleNumber(list1)

	list2 := []int{4, 1, 2, 1, 2}
	testSingleNumber(list2)

	list3 := []int{1}
	testSingleNumber(list3)
}
