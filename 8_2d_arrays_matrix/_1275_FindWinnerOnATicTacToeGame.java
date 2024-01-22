import java.util.Arrays;

public class _1275_FindWinnerOnATicTacToeGame {
    
    /*
    1275. Find Winner on a Tic Tac Toe Game
    Tic-tac-toe is played by two players A and B on a 3 x 3 grid. 
    The rules of Tic-Tac-Toe are:
    
    Players take turns placing characters into empty squares ' '.
    The first player A always places 'X' characters, while the second player B always places 'O' characters.
    'X' and 'O' characters are always placed into empty squares, never on filled ones.
    The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.
    Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
    
    You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
    
     
    Example 1:
    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
    Output: "A"
    Explanation: A wins, they always play first.
    
    Example 2:
    Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
    Output: "B"
    Explanation: B wins.
    
    Example 3:
    Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
    Output: "Draw"
    Explanation: The game ends in a draw since there are no moves to make.
     
    
    Constraints:
    1 <= moves.length <= 9
    moves[i].length == 2
    0 <= rowi, coli <= 2
    There are no repeated elements on moves.
    moves follow the rules of tic-tac-toe.
     */

    public static void main(String[] args) {

        int[][] moves = {
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };
        testTictactoe(moves);

        int[][] moves2 = {
                {0, 0},
                {1, 1},
                {0, 1},
                {0, 2},
                {1, 0},
                {2, 0}
        };
        testTictactoe(moves2);

        int[][] moves3 = {
                {0, 0},
                {1, 1},
                {2, 0},
                {1, 0},
                {1, 2},
                {2, 1},
                {0, 1},
                {0, 2},
                {2, 2}
        };
        testTictactoe(moves3);
    }

    public static String tictactoe(int[][] moves) {

        int[][] aMoves = new int[3][3];
        int[][] bMoves = new int[3][3];

        for (int i = 0; i < moves.length; i++) {

            int row = moves[i][0];
            int col = moves[i][1];

            if (i % 2 == 0) 
                aMoves[moves[i][0]][moves[i][1]] = 1;
            else 
                bMoves[moves[i][0]][moves[i][1]] = 1;
        }

        if (checkWinner(aMoves)) return "A";
        else if (checkWinner(bMoves)) return "B";
        else if (moves.length == 9) return "Draw";
        else return "Pending";
    }

    private static boolean checkWinner(int[][] aMoves) {
        for (int i = 0; i < aMoves.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < aMoves[i].length; j++) {
                rowSum += aMoves[i][j];
                colSum += aMoves[j][i];
            }
            if (rowSum == 3 || colSum == 3) return true;
        }

        int diagonalPrincipalSum = 0;
        int diagonalSecondarySum = 0;

        for (int i = 0; i < aMoves.length; i++) {
            diagonalPrincipalSum += aMoves[i][i];
            diagonalSecondarySum += aMoves[i][aMoves.length - 1 - i];
        }

        return diagonalPrincipalSum == 3 || diagonalSecondarySum == 3;
    }

    public static void testTictactoe(int[][] moves) {
        System.out.print("Moves: " + Arrays.deepToString(moves));
        printAMoves(moves);
        printBMoves(moves);

        printActualMoves(moves);

        long start = System.nanoTime();
        String result = tictactoe(moves);
        long end = System.nanoTime();

        System.out.println("\nResult: " + result);
        System.out.printf("Runtime: %d ns\n", (end - start));
        System.out.printf("Runtime: %.6f ms\n\n", (end - start) / 1_000_000.00);
    }

    public static void printAMoves(int[][] moves) {
        System.out.print("\nA moves: ");
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0)
                System.out.print(Arrays.toString(moves[i]));
        }
    }

    public static void printBMoves(int[][] moves) {
        System.out.print("\nB moves: ");
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 != 0)
                System.out.print(Arrays.toString(moves[i]));
        }
    }

    public static void printActualMoves(int[][] moves) {
        char[][] board = new char[3][3];

        // Preencher o tabuleiro com os movimentos
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];

            char symbol = (i % 2 == 0) ? 'X' : 'O';
            board[row][col] = symbol;
        }

        // Imprimir o tabuleiro
        System.out.println('\n');
        System.out.println(" +---+---+---");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0)
                    System.out.print("   ");
                else
                    System.out.print(" " + board[i][j] + " ");

                if (j < 2) System.out.print("|");

            }
            System.out.println();
            if (i < 2) System.out.println(" +---+---+---");
        }
    }
}