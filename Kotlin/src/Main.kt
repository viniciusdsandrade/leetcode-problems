import _11_binary_search_tree.TreeNode
import _11_binary_search_tree.containsIterative
import _11_binary_search_tree.containsRecursive
import kotlin.system.measureNanoTime


fun buildSkewedTree(height: Int): TreeNode<Int> {
    val root = TreeNode(0)
    var current = root
    for (i in 1 until height) {
        val child = TreeNode(i)
        current.left = child
        current = child
    }
    return root
}

fun main() {
    val heights = listOf(5, 50, 500,5000)
    println("Testando alturas: $heights\n")

    for (h in heights) {
        // Constrói árvore e define valor-alvo como o mais profundo (pior caso)
        val tree = buildSkewedTree(h)
        val target = h - 1

        // Mede busca recursiva
        val timeRec = measureNanoTime {
            val found = containsRecursive(tree, target)
            // Só para garantir compilação sem otimização agressiva:
            require(found) { "Valor não encontrado (recursivo) em h=$h" }
        }

        // Mede busca iterativa
        val timeIter = measureNanoTime {
            val found = containsIterative(tree, target)
            require(found) { "Valor não encontrado (iterativo) em h=$h" }
        }

        println("Altura = $h:")
        println("  Recursivo: ${timeRec / 1_000_000.0} ms")
        println("  Iterativo: ${timeIter / 1_000_000.0} ms")
        println()
    }
}