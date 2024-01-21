public class _36_ValidSudoku {

    /*
    36. Valid Sudoku
    Determine if a 9 x 9 Sudoku board is valid.
    Only the filled cells need to be validated according
    to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.
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
        testIsValidSudoku(board1);

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        testIsValidSudoku(board2);
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col];
                    board[row][col] = '.';
                    if (!isValidPlacement(board, row, col, num)) return false;

                    board[row][col] = (char) num;
                }
            }
        }
        return true;
    }


    private static boolean isValidPlacement(char[][] board, int row, int col, int num) {
        return !isNumberInRow(board, row, num) &&
                !isNumberInCol(board, col, num) &&
                !isNumberInBox(board, row, col, num);
    }

    private static boolean isNumberInRow(char[][] board, int row, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return true;
        }
        return false;
    }

    private static boolean isNumberInCol(char[][] board, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            if (chars[col] == num)
                return true;
        }
        return false;
    }

    private static boolean isNumberInBox(char[][] board, int row, int col, int num) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num)
                    return true;
            }
        }
        return false;
    }

    /*
    private static boolean isNumberInBox(char[][] board, int row, int col, int num) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        System.out.println("Checking box at boxRow: " + boxRow + ", boxCol: " + boxCol);

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (Character.isDigit(board[i][j])) {
                    System.out.println("Checking board[" + i + "][" + j + "]: " + Character.getNumericValue(board[i][j]) + ", num: " + num);
                    if (Character.getNumericValue(board[i][j]) == num) {
                        System.out.println("Number " + num + " found in the box!");
                        return true;
                    }
                } else {
                    System.out.println("Checking board[" + i + "][" + j + "]: . , num: " + num);
                }
            }
        }
        System.out.println("Number " + num + " not found in the box.");
        return false;
    }
     */


    public static void testIsValidSudoku(char[][] board) {

        System.out.println("\nInput: \n" + printSudoku(board));

        long start = System.nanoTime();
        boolean result = isValidSudoku(board);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.printf("Runtime: %d ns\n", end - start);
        System.out.println("Runtime: " + (end - start) / 1_000_000.0 + " ms");
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