package 动态规划;

/*
* 64 最小路径和
* */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0||grid[0].length==0)return 0;
        if(grid.length==1&&grid[0].length==1)return grid[0][0];

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = 0;
                if(i-1>=0){
                    min = dp[i-1][j];
                }
                if(j-1>=0&&(min==0||dp[i][j-1]<min)){
                    min = dp[i][j-1];
                }
                dp[i][j] = grid[i][j]+min;
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        new MinPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
