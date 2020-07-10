package 动态规划;
/*
* 74 编辑距离
* */
class MinDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0||word2.length()==0)return word2.length();

        int[][] dp = new int[word2.length()][word1.length()];
        for (int i = 0; i < word2.length(); i++) {
            dp[i][0] = i==0?0:dp[i-1][0];
            if(word2.charAt(i)!=word1.charAt(0)){
                dp[i][0] += 1;
            }
        }
        if(word1.length()>1){
            for (int i = 1; i < word1.length(); i++) {
                dp[0][i] = i==0?0:dp[0][i-1];
                if(word2.charAt(0)!=word1.charAt(i)){
                    dp[0][i] += 1;
                }
            }
            if(word2.length()>1){
                for (int i = 1; i < word2.length(); i++) {
                    for (int j = 1; j < word1.length(); j++) {
                        if(word1.charAt(j)==word2.charAt(i)){
                            dp[i][j] = dp[i-1][j-1];
                        }else{
                            dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
                        }
                    }
                }
            }
        }
        return dp[word2.length()-1][word1.length()-1];
    }

    public static void main(String[] args) {
        new MinDistance().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
    }
    public int min(int a,int b,int c){
        return a<b?(a<c?a:c):(b<c?b:c);
    }
}