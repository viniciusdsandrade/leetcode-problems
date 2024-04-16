package main

import (
	"fmt"
	"time"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l *ListNode) String() string {
	if l == nil {
		return "[]"
	}
	result := ""
	for l != nil {
		result += fmt.Sprintf("%d -> ", l.Val)
		l = l.Next
	}
	result = result[:len(result)-4] // Remove o último ' -> '
	return "[" + result + "]"
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	preheat := &ListNode{}
	prev := preheat

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			prev.Next = l1
			l1 = l1.Next
		} else {
			prev.Next = l2
			l2 = l2.Next
		}
		prev = prev.Next
	}

	if l1 != nil {
		prev.Next = l1
	} else {
		prev.Next = l2
	}

	return preheat.Next
}

func testMergeTwoLists(list1 *ListNode, list2 *ListNode) {
	fmt.Println("List 1: ", list1)
	fmt.Println("List 2: ", list2)

	start := time.Now()
	result := mergeTwoLists(list1, list2)
	elapsed := time.Since(start)

	fmt.Println("Result: ", result)
	fmt.Println("Execution time: ", elapsed)
}

func main() {

	list1 := &ListNode{1, &ListNode{2, &ListNode{4, nil}}}
	list2 := &ListNode{1, &ListNode{3, &ListNode{4, nil}}}
	testMergeTwoLists(list1, list2)

	list3 := &ListNode{}
	list4 := &ListNode{}
	testMergeTwoLists(list3, list4)

	list5 := &ListNode{}
	list6 := &ListNode{0, nil}
	testMergeTwoLists(list5, list6)
}
