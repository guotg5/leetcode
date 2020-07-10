package 动态规划;

/*
* 简单爬楼梯  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* */
public class ClimberStairs {

    public int climber(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
}
