/**
 * Problem desc is in https://leetcode.com/problems/number-of-islands/
 */
public class numberOfIslands {

    public static int numberOfIslands(char[][] grid){
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    paint(grid,i,j);
                    cnt ++;
                }
            }
        }

        return cnt;
    }

    private static void paint(char[][] grid, int i, int j){
            grid[i][j]='2';
            if(j<grid[0].length-1 && grid[i][j+1]=='1'){
                paint(grid,i,j+1);
            }
            if(j>0 && grid[i][j-1]=='1'){
                paint(grid,i,j-1);
            }
            if(i< grid.length-1 && grid[i+1][j]=='1'){
                paint(grid,i+1,j);
            }
            if(i>0 && grid[i-1][j]=='1'){
                paint(grid,i-1,j);
            }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0','1','1','1','1'},
                {'1','0','0','1','0'},
                {'0','0','1','0','1'}
        };

        System.out.println(numberOfIslands(grid));
    }

}
