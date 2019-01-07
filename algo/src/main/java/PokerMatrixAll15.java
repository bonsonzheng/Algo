import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * With given 9 poker cards 1-9, make them as a 3*3 matrix. Each row, each column and each diagonal should add up equals to 15
 */

public class PokerMatrixAll15 {

    public static List<String> solutionString = new ArrayList<String>();
    private static int count = 0;

    public static boolean solve(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    for (int v = 1; v <= 9; v++) {
                        if (isValid(board, i, j, v)) {
                            board[i][j] = v;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }

            }
        }

        /** THis is to find out all solutions, if remove this statement, the program exits when the 1st solution is found */
        recordSolutionAndContinue(board);

        return true;

    }

    private static void recordSolutionAndContinue(int[][] board) {
        String solutionAsString = toString(board);
        System.out.println("----------- Solution " + ++count + "-------------");
        System.out.println(solutionAsString);
        solutionString.add(solutionAsString);
        init(board);
        solve(board);
    }

    private static String toString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean isValid(int[][] board, int row, int col, int v) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == v) {
                    return false;
                }
            }
        }

        /** This is to prove that if 5 is not in the center of the matrix, there will have no solution */
//        if (row == 1 && col == 1 && v == 5) {
//            return false;
//        }

        if (row == 2 && col == 2) {
            if (board[0][0] > 0 && board[1][1] > 0 && (board[0][0] + board[1][1] + v != 15)) {
                return false;
            } else {
                if (solutionString.contains(toString(board).replace(String.valueOf(0), String.valueOf(v)))) {
                    return false;
                }
            }
        }

        if (row == 2 && col == 0) {
            if (board[0][2] > 0 && board[1][1] > 0 && (board[0][2] + board[1][1] + v != 15)) {
                return false;
            }
        }

        if (col == 2) {
            if (board[row][0] > 0 && board[row][1] > 0 && (board[row][0] + board[row][1] + v != 15)) {
                return false;
            }
        }

        if (row == 2) {
            if (board[0][col] > 0 && board[1][col] > 0 && (board[0][col] + board[1][col] + v != 15)) {
                return false;
            }
        }

        return true;
    }

    private static void init(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        solve(board);
    }

}