import java.util.Arrays;

public class Sudoku {
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '-';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }
        }

        int cubrow = (row / 3) * 3;
        int cubcol = (col / 3) * 3;
        for (int x = cubrow; x < cubrow + 3; x++) {
            for (int y = cubcol; y < cubcol + 3; y++) {
                if (board[x][y] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '-', '-', '7', '-', '-', '-', '-'},
                {'6', '-', '-', '1', '9', '5', '-', '-', '-'},
                {'-', '9', '8', '-', '-', '-', '-', '6', '-'},
                {'8', '-', '-', '-', '6', '-', '-', '-', '3'},
                {'4', '-', '-', '8', '-', '3', '-', '-', '1'},
                {'7', '-', '-', '-', '2', '-', '-', '-', '6'},
                {'-', '6', '-', '-', '-', '-', '2', '8', '-'},
                {'-', '-', '-', '4', '1', '9', '-', '-', '5'},
                {'-', '-', '-', '-', '8', '-', '-', '7', '9'},
        };
        if (solveSudoku(board)) {
            System.out.println("solved:");
            print(board);
        } else {
            System.out.println("Failed to solveNQueue");
        }


    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
