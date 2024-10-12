import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _834_SumOfDistancesInTree {
    /*
    834. Sum of Distances in Tree
    There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

    You are given the integer n and the array edges where edges[i] = [ai,bi] indicates
     that there is an edge between nodes ai and bi in the tree.

    Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

    Example 1:
    Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
    Output: [8,12,6,10,10,10]
    Explanation: The tree is shown above.
    We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
    equals 1 + 1 + 2 + 2 + 2 = 8.
    Hence, answer[0] = 8, and so on.

    Example 2:
    Input: n = 1, edges = []
    Output: [0]

    Example 3:
    Input: n = 2, edges = [[1,0]]
    Output: [1,1]

    Constraints:
    1 <= n <= 3 * 10^4
    edges.length == n - 1
    edges[i].length == 2
    0 <= ai, bi < n
    ai != bi
    The given input represents a valid tree.
     */

    public static void main(String[] args) {

        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        testSumOfDistancesInTree(6, edges1);

        int[][] edges2 = {};
        testSumOfDistancesInTree(1, edges2);

        int[][] edges3 = {{1, 0}};
        testSumOfDistancesInTree(2, edges3);

    }

    /**
     * Calcula a soma das distâncias entre cada nó e todos os outros nós em uma árvore.
     *
     * @param n     O número de nós na árvore.
     * @param edges As arestas da árvore representadas como pares [ai, bi].
     * @return Um array onde answer[i] é a soma das distâncias do nó i a todos os outros nós.
     */
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        // 1. Constrói a representação da lista de adjacências da árvore.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>()); // Inicializa listas vazias para cada nó

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // Adiciona arestas bidirecionais ao grafo
            graph.get(edge[1]).add(edge[0]);
        }

        // 2. Executa a Busca em Profundidade (DFS) para calcular:
        //    - count: O número de nós na subárvore enraizada em cada nó.
        //    - dist: A soma das distâncias de cada nó a todos os nós em sua subárvore.
        int[] count = new int[n];
        int[] dist = new int[n];
        dfs(0, -1, graph, count, dist); // Inicia a DFS a partir do nó 0

        // 3. Executa outra DFS para calcular a resposta final para cada nó.
        int[] answer = new int[n];
        dfs2(0, -1, graph, count, dist, answer); // Inicia a segunda DFS a partir do nó 0
        return answer;
    }

    /**
     * Função auxiliar de DFS para calcular os arrays count e dist.
     *
     * @param node   O nó atual sendo visitado na DFS.
     * @param parent O nó pai do nó atual (ou -1 se for a raiz).
     * @param graph  A lista de adjacências representando a árvore.
     * @param count  Array para armazenar a contagem de nós nas subárvores.
     * @param dist   Array para armazenar a soma das distâncias nas subárvores.
     */
    private static void dfs(int node, int parent, List<List<Integer>> graph, int[] count, int[] dist) {
        for (int child : graph.get(node)) { // Itera sobre os filhos do nó atual
            if (child != parent) { // Evita voltar para o nó pai
                dfs(child, node, graph, count, dist); // Recursão para explorar a subárvore do filho
                count[node] += count[child]; // Acumula a contagem de nós da subárvore do filho
                dist[node] += dist[child] + count[child]; // Acumula a soma das distâncias da subárvore do filho
            }
        }
        count[node]++; // Inclui o próprio nó na contagem
    }

    /**
     * Função auxiliar de DFS para calcular o array de resposta final.
     *
     * @param node   O nó atual sendo visitado na DFS.
     * @param parent O nó pai do nó atual (ou -1 se for a raiz).
     * @param graph  A lista de adjacências representando a árvore.
     * @param count  Array com a contagem de nós nas subárvores.
     * @param dist   Array com a soma das distâncias nas subárvores.
     * @param answer Array para armazenar a resposta final (soma das distâncias para cada nó).
     */
    private static void dfs2(int node, int parent, List<List<Integer>> graph, int[] count, int[] dist, int[] answer) {
        answer[node] = dist[node]; // Inicializa a resposta do nó com a soma das distâncias de sua subárvore
        for (int child : graph.get(node)) {
            if (child != parent) {
                // Ajusta a distância para o nó filho com base nas informações do pai.
                dist[child] = dist[node] - count[child] + (count.length - count[child]);
                dfs2(child, node, graph, count, dist, answer); // Recursão para calcular a resposta para o filho
            }
        }
    }

    public static void testSumOfDistancesInTree(int n, int[][] edges) {
        System.out.println("Input: n = " + n + ", edges = " + Arrays.deepToString(edges));

        long start = System.nanoTime();
        int[] result = sumOfDistancesInTree(n, edges);
        long end = System.nanoTime();

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Runtime: " + (end - start) + "ns\n");
    }
}
