import java.util.Arrays;

public class NQueue {
    public static char[][] solveNQueue(int n) {
        char[][] board = new char[n][n];
        init(n, board);
        solve(board, 0);
        return board;
    }

    private static void init(int n, char[][] board) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '-');
        }
    }

    private static boolean solve(char[][] board, int row) {
        if (row >= board[0].length) {
            print(board);
        }

        for (int colToTry = 0; colToTry < board[0].length; colToTry++) {
            if (isSafe(board, row, colToTry)) {
                placeQueue(board, row, colToTry);
                if (solve(board, row + 1)) {
                    return true;
                } else {
                    removeQueue(board, row, colToTry);
                }
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j]=='Q'){
                    if(Math.abs(i-row) == Math.abs(j-col) || i==row || j==col){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void placeQueue(char[][] board, int row, int col) {
        board[row][col] = 'Q';
    }

    private static void removeQueue(char[][] board, int row, int col) {
        board[row][col] = '-';
    }

    private static void print(char[][] board) {
        System.out.println("Got solution: ");
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString((board[i])));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solveNQueue(4);
    }


}
