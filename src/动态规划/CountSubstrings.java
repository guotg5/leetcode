package 动态规划;
/*
* 647
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
* */
class CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int sum = 0;
        boolean dp[][] = new boolean[len][len];
        //初始化 单个字符 必然是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //从右下角遍历
        for (int i = len-1; i > 0; i--) {
            for (int j = i-1; j > -1; j--) {
                if(i-j==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                }else{

                }
            }
        }
        return sum;
    }
}