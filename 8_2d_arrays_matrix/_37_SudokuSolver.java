public class _37_SudokuSolver {

    /*
    37. Sudoku Solver
    Write a program to solve a Sudoku puzzle by filling
    the empty cells.

    A sudoku solution must satisfy all the
    following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.

    Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.
     */

    public static void main(String[] args) {

        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        testSolveSudoku(board1);

        char[][] board2 = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        testSolveSudoku(board2);
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = '.'; // Undo the choice if it leads to failure
                        }
                    }
                    return false;
                }
            }
        }
        return true; // All cells are filled (base case for recursion)
    }


    private static boolean isNumberInRow(char[][] board, int row, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCol(char[][] board, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }


    private static boolean isNumberInBox(char[][] board, int startRow, int startCol, char num) {

        int boxRow = startRow - startRow % 3;
        int boxCol = startCol - startCol % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char num) {

        return !isNumberInRow(board, row, num) &&
                !isNumberInCol(board, col, num) &&
                !isNumberInBox(board, row, col, num);
    }

    public static void testSolveSudoku(char[][] board) {

        System.out.println("\nInput: \n" + printSudoku(board));

        long start = System.nanoTime();
        solveSudoku(board);
        long end = System.nanoTime();

        System.out.println("\nOutput: \n" + printSudoku(board));
        System.out.printf("runtime: %d ns\n", end - start);
        System.out.printf("runtime: %.6f ms\n", (end - start) / 1_000_000.00);
    }

    public static String printSudoku(char[][] board) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append("---------------------\n");
            }

            for (int j = 0; j < board[i].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    sb.append("| ");
                }

                sb.append(board[i][j]).append(" ");

                if (j == board[i].length - 1) {
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }
}