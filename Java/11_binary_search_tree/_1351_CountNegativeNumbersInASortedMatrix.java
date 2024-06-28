import java.util.Arrays;

public class _1351_CountNegativeNumbersInASortedMatrix {

    /*
    1351. Count Negative Numbers in a Sorted Matrix
    Given an m x n matrix grid which is sorted in non-increasing order both row-wise and
    column-wise, return the number of negative numbers in grid.

    Example 1:
    Input: grid = [
        [4,3,2,-1],
        [3,2,1,-1],
        [1,1,-1,-2],
        [-1,-1,-2,-3]
    ]
    Output: 8
    Explanation: There are 8 the number of negatives in the matrix.

    Example 2:
    Input: grid = [
        [3,2],
        [1,0]
    ]
    Output: 0

    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

    Follow up: Could you find an O(n + m) solution?
     */

    public static void main(String[] args) {

        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        testCountNegatives(grid1);

        int[][] grid2 = {
                {3, 2},
                {1, 0}
        };
        testCountNegatives(grid2);
    }

    /**
     * Conta o número de elementos negativos em uma matriz bidimensional.
     *
     * @param grid a matriz bidimensional de inteiros
     * @return o número de elementos negativos na matriz
     */
    public static int countNegatives(int[][] grid) {

        int count = 0; // Inicializa o contador de números negativos
        int row = grid.length; // Número de linhas na matriz
        int col = grid[0].length; // Número de colunas na matriz

        // Percorre cada elemento na matriz
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Verifica se o elemento é negativo
                if (grid[i][j] < 0) {
                    count++; // Incrementa o contador se o elemento for negativo
                }
            }
        }

        return count; // Retorna o número total de elementos negativos
    }

    /**
     * Conta o número de elementos negativos em uma matriz bidimensional de forma otimizada.
     * Assume que cada linha da matriz é ordenada em ordem decrescente.
     *
     * @param grid a matriz bidimensional de inteiros
     * @return o número de elementos negativos na matriz
     */
    public static int countNegatives2(int[][] grid) {

        int count = 0; // Inicializa o contador de números negativos
        int row = grid.length; // Número de linhas na matriz
        int col = grid[0].length; // Número de colunas na matriz

        int i = 0; // Índice da linha
        int j = col - 1; // Índice da coluna, começando pela última coluna

        // Percorre a matriz de forma otimizada
        while (i < row && j >= 0) {
            if (grid[i][j] < 0) {
                count += row - i; // Adiciona todos os elementos restantes na coluna atual
                j--; // Move para a coluna anterior
            } else {
                i++; // Move para a próxima linha
            }
        }

        return count; // Retorna o número total de elementos negativos
    }

    public static void testCountNegatives(int[][] grid) {
        System.out.println("Input: grid = " + Arrays.deepToString(grid));

        long start = System.nanoTime();
        int result = countNegatives(grid);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        int result2 = countNegatives2(grid);
        long end2 = System.nanoTime();

        System.out.println("Output1: " + result);
        System.out.println("Output2: " + result2);
        System.out.println("Runtime1: " + (end - start) + "ns");
        System.out.println("Runtime2: " + (end2 - start2) + "ns\n");
    }
}
