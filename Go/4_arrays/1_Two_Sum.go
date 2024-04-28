package main

import (
	"fmt"
	"time"
)

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)

	for i, num := range nums {
		complement := target - num
		if j, ok := m[complement]; ok {
			return []int{j, i}
		}
		m[num] = i
	}
	return nil
}

func testTwoSum(nums []int, target int) {
	fmt.Println("List:	 ", nums)
	fmt.Println("Target: ", target)

	start := time.Now()
	result := twoSum(nums, target)
	elapsed := time.Since(start)

	fmt.Println("Result: ", result)
	fmt.Println("Execution time: ", elapsed.Nanoseconds())
}

func main() {
	list1 := []int{2, 7, 11, 15}
	target1 := 9
	testTwoSum(list1, target1)

	list2 := []int{3, 2, 4}
	target2 := 6
	testTwoSum(list2, target2)
}
