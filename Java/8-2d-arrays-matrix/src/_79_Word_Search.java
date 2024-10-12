public class _79_Word_Search {
    
    /*
    79. Word Search
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally 
    or vertically neighboring. The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false

    Constraints: 
    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.
     
    Follow up: Could you use search pruning to make your solution faster with a larger board?
     */

    public static void main(String[] args) {

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        testExist(board1, word1);

        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word2 = "SEE";
        testExist(board2, word2);

        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCB";
        testExist(board3, word3);
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, visited, i, j, word, 0);
                if (result) return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;

        if (dfs(board, visited, i + 1, j, word, index + 1) || dfs(board, visited, i - 1, j, word, index + 1) ||
                dfs(board, visited, i, j + 1, word, index + 1) || dfs(board, visited, i, j - 1, word, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void testExist(char[][] board, String word) {
        System.out.println("Input: ");
        printMatrix(board);

        long t1 = System.nanoTime();
        boolean result = exist(board, word);
        long t2 = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (t2 - t1) + " ns");
    }

    public static void printMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : matrix) {
            sb.append("[ ");
            for (char element : row) {
                sb.append(element).append(" ");
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}