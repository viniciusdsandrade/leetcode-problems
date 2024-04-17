package main

import (
	"fmt"
	"strings"
	"time"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	// Se o nó atual é nulo, simplesmente retorne nulo.
	if root == nil {
		return nil
	}

	// Salve as subárvores esquerda e direita em variáveis temporárias.
	tempLeft := root.Left
	tempRight := root.Right

	// Inverta as subárvores esquerda e direita do nó atual.
	root.Left = invertTree(tempRight)
	root.Right = invertTree(tempLeft)

	// Depois de inverter as subárvores, retorne o nó raiz.
	return root
}

func (t *TreeNode) toString(indent string, level int) string {
	if t == nil {
		return ""
	}

	s := strings.Repeat(indent, level) + fmt.Sprintf("|-- %d\n", t.Val)

	s += t.Left.toString(indent, level+1)
	s += t.Right.toString(indent, level+1)

	return s
}

func testInvertTree(tree *TreeNode) {
	fmt.Println("Árvore original:")
	fmt.Println(tree.toString("    ", 0))

	start := time.Now()
	inverted := invertTree(tree)
	elapsed := time.Since(start)

	fmt.Println("\nÁrvore invertida:")
	fmt.Println(inverted.toString("    ", 0))
	fmt.Println("Execution time: ", elapsed)
}

func main() {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 3,
			},
			Right: &TreeNode{
				Val: 4,
			},
		},
		Right: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 6,
			},
			Right: &TreeNode{
				Val: 7,
			},
		},
	}

	testInvertTree(root)
}
