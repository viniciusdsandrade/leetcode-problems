package _11_binary_search_tree

data class TreeNode<T>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

fun <T> containsRecursive(node: TreeNode<T>?, value: T): Boolean {
    if (node == null) return false
    if (node.value == value) return true
    return containsRecursive(node.left, value) || containsRecursive(node.right, value)
}

fun <T> containsIterative(root: TreeNode<T>?, value: T): Boolean {
    val stack = ArrayDeque<TreeNode<T>?>()
    if (root != null) stack.add(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeLast()
        if (node != null) {
            if (node.value == value) return true
            // Empilha filhos para percorrer em profundidade
            node.right?.let { stack.add(it) }
            node.left?.let { stack.add(it) }
        }
    }
    return false
}

