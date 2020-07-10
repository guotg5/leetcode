package 动态规划;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    dp[i][j] = 1;
                }else{
                    if(i-1>=0){
                        dp[i][j]+=dp[i-1][j];
                    }
                    if(n-1>=0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int l = m>n?n:m;
        int max = m>n?m:n;
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(i==0&&j==0){
                    dp[i][j] = 1;
                }else{
                    if(i-1>=0){
                        dp[i][j]+=dp[i-1][j];
                    }
                    if(j-1>=0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[l-1][l-1]+(max*max-l*l+max-l)/2;
    }
}
