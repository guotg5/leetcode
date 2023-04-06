package 动态规划;

/**
 * 动态规划
 *什么是动态规划算法呢？
 *
 * 动态规划过程是：每次决策依赖于当前状态，又随即引起状态的转移。一个决策序列就是在变化的状态中产生出来的，所以，这种多阶段最优化决策解决问题的过程就称为动态规划(DP)。
 * 动态规划常用于的一个问题就是求最值， 比如说最常见的求最长递增子序列等问题。其实动态规划的问题核心仍然是穷举，想一下求最值，那最可能的就是把所有结果列出来，谁最大要谁。
 * 动态规划是自底向上的处理思想，但它首先要自顶向下的把原问题分解为若干子问题，然后自底向上，先求解最小的子问题，把结果存储在表格中，在求解大的子问题时，直接从表格中查询小的子问题的解，避免重复计算，从而提高算法效率。
 * 核心思想：从上往下分析问题，大问题可以分解为子问题，子问题中还有更小的子问题，然后逐个破解！
 * 动态规划操作过程：
 *
 * 通常动态规划都按照这几步骤进行操作：
 * 1.确定dp数组及其下标含义；
 * 2.确定递推公式，即状态转移方程；
 * 3.dp初始化
 * 4.返回结果
 *
 * @Author guotiangang
 * @Date 2023/4/3 20:02
 */
public class Common {

    /**
     * 斐波那契数列
     *  dp记录当前列对应的数
     *  公式：f n = f n-1 + f n-2
     **/
    public static int fibonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 简单爬楼梯 一次一阶或者两阶
     *  dp 记录爬到第i阶的种数
     *  公式 f n = f n-1 + f n-2
     **/
    public int climber(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
     * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯
     * dp 记录第i阶最小成本
     * f n = Cost n + min ( f n-2 , f n-1)
     **/
    public int minCost(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return dp[dp.length-1];
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * [7, 1, 5, 3, 6, 4]
     * [0, 0, 4, 2, 6, 4]
     * [-7,-1,-1,-1,6,4]
     * dp[i][j]
     **/
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;//没有持股的时候现金
        dp[0][1]=dp[0][0]-prices[0];//持股的时候现金

        for (int i = 1; i < prices.length; i++) {
            //没有持股：max(昨天已经卖了, 卖了)
            dp[i][0] = Math.max(dp[i-1][0], prices[i]+dp[i-1][1]);
            //持股 昨天已经买了 今天买了
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[dp.length-1][0];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * dp[][] 走到当前位置最小和
     * f i j = curr + min(f i-1 j , f i j-1)
     **/
    public int minPathSum(int[][] paths) {
        int[][] sum = new int[paths.length][paths[0].length];

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                int top = 0;
                int left = 0;
                if(i != 0) {
                    top = sum[i-1][j];
                }
                if(j != 0) {
                    left = sum[i][j-1];
                }
                sum[i][j] = Math.min(top, left) + paths[i][j];
            }
        }
        return sum[paths.length-1][paths[0].length-1];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     * [100,1,1,100]
     * dp[][] 偷 没偷
     *
     **/
    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     *
     * 第一个房子和最后一个房子同时只能偷一个
     * 拆成两次计算 从前到后 从后到前 取最大值
     **/
//    public static int rob2(int[] nums) {
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = nums[0];
//        dp[0][1] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = dp[i-1][1] + nums[i];
//            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
//        }
//        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
//    }

    /**
     * 最长回文子串 给你一个字符串 s，找到 s 中最长的回文子串。
     * 输入：s = "cbbd"
     * 输出："bb"
     * 一个子串 可以用起点i 终点j表示
     * 是否为回文子串又可以通过自身的子串来判断
     * 怎么保证计算时 自身的子串都计算过了呢 以一个点为中点 循环向两边同时扩展就行
     **/
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String result = "";
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(i == j) {
                    dp[i][j] = true;
                }else if(j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbcc"));
    }

}
